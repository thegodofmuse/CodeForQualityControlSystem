package com.example.qualitycontrolsystem.login.service.hrp_service;

import com.example.qualitycontrolsystem.login.dto.hrp_dto.*;
import com.example.qualitycontrolsystem.login.mapper.hrp_mapper.GradesFormMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class GradesFormService {
    @Autowired
    private GradesFormMapper gradesFormMapper;

    public GradesFormDto getGradesFormData(String userTime) {
        // 获取MedicalServicesSectionData
        List<MedicalServicesSectionDto> medicalServicesSectionData = gradesFormMapper.getMedicalServicesSectionData(userTime);

        // 获取MedicalRecordsSectionData
        List<MedicalRecordsSectionDto> medicalRecordsSectionData = gradesFormMapper.getMedicalRecordsSectionData(userTime);

        // 获取并设置最终科室得分
        List<FinalOfficeScoreDto> finalOfficeScores = getFinalOfficeScores(userTime);

        // 设置sumGradesForm（具体根据业务逻辑设置）
        List<SumGradesFormDto> sumGradesFormData = calculateSumGrades(finalOfficeScores, medicalRecordsSectionData, medicalServicesSectionData);

        //获取加分项
        List<BonusPointsProjectDto> bonusPointsProjectData = gradesFormMapper.getBonusPointsProjectData(userTime);



        // 创建GradesFormDto对象并设置各个部分的数据
        GradesFormDto gradesFormDto = new GradesFormDto();
        gradesFormDto.setMedicalServicesSectionData(medicalServicesSectionData);
        gradesFormDto.setMedicalRecordsSectionData(medicalRecordsSectionData);
        gradesFormDto.setFinalOfficeScores(finalOfficeScores);
        gradesFormDto.setSumGradesFormData(sumGradesFormData);
        gradesFormDto.setBonusPointsProjectData(bonusPointsProjectData);



        return gradesFormDto;
    }
    //对质控反馈单的最终得分进行判断
    public List<FinalOfficeScoreDto> getFinalOfficeScores(String userTime) {
        // 获取质控反馈单的分值
        List<QcSumScoreDto> qcSumScoreData = gradesFormMapper.getQcSumScoreData(userTime);
        // 获取反馈后的分数分值
        List<FinalScoreDto> finalScoreData = gradesFormMapper.getFinalScoreData(userTime);

        // 创建一个 HashMap 来存储 finalScoreData 的内容
        Map<String, BigDecimal> finalScoreMap = finalScoreData.stream()
                .collect(Collectors.toMap(FinalScoreDto::getOfficeName, FinalScoreDto::getFinalScore));

        // 创建一个 List 来存储结果
        List<FinalOfficeScoreDto> finalOfficeScores = new ArrayList<>();

        // 遍历 qcSumScoreData
        for (QcSumScoreDto qcSumScore : qcSumScoreData) {
            FinalOfficeScoreDto finalOfficeScore = new FinalOfficeScoreDto();
            finalOfficeScore.setOfficeName(qcSumScore.getOfficeName());
            // 从 HashMap 中查找 finalScore，如果存在则使用，否则使用 qcOfficeScore
            finalOfficeScore.setFinalOfficeScore(finalScoreMap.getOrDefault(qcSumScore.getOfficeName(), qcSumScore.getQcOfficeScore()));
            finalOfficeScores.add(finalOfficeScore);
        }

        return finalOfficeScores;
    }

    //计算hrp表单总分数
    public List<SumGradesFormDto> calculateSumGrades(List<FinalOfficeScoreDto> finalOfficeScores,
                                                     List<MedicalRecordsSectionDto> medicalRecordsSectionData,
                                                     List<MedicalServicesSectionDto> medicalServicesSectionData) {
        // 创建一个 HashMap，用于存储 officeName 对应的中间值
        Map<String, BigDecimal> intermediateScores = new HashMap<>();
        for (FinalOfficeScoreDto finalOfficeScore : finalOfficeScores) {
            String officeName = finalOfficeScore.getOfficeName();
            BigDecimal score = finalOfficeScore.getFinalOfficeScore();
            for (MedicalRecordsSectionDto medicalRecord : medicalRecordsSectionData) {
                if (officeName.equals(medicalRecord.getOfficeName())) {
                    score = score.add(medicalRecord.getMedicalRecordPageScore());
                    break;
                }
            }
            intermediateScores.put(officeName, score);
        }

// ...

        List<SumGradesFormDto> sumGradesFormDtos = new ArrayList<>();
        for (Map.Entry<String, BigDecimal> entry : intermediateScores.entrySet()) {
            String officeName = entry.getKey();
            BigDecimal score = entry.getValue();
            for (MedicalServicesSectionDto medicalService : medicalServicesSectionData) {
                if (officeName.equals(medicalService.getOfficeName())) {
                    score = score.add(medicalService.getMedTechServiceCapabilities())
                            .add(medicalService.getPrescriptiveTasks())
                            .add(medicalService.getContinuousImprovementMetrics());
                    break;
                }
            }
            SumGradesFormDto sumGradesFormDto = new SumGradesFormDto();
            sumGradesFormDto.setOfficeName(officeName);
            sumGradesFormDto.setSumGrades(score);
            sumGradesFormDtos.add(sumGradesFormDto);
        }
        return sumGradesFormDtos;
    }


}
