package com.example.qualitycontrolsystem.login.service.hrp_service;

import com.example.qualitycontrolsystem.login.dto.hrp_dto.*;
import com.example.qualitycontrolsystem.login.mapper.hrp_mapper.EmergencyGradesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmergencyGradesService {
    @Autowired
    private EmergencyGradesMapper emergencyGradesMapper;

    public EmergencyGradesDto getEmergencyGradesData (String userTime) {
        // 获取MedicalServicesSectionData
        List<MedicalServicesSectionDto> emergencyMedicalServicesData = emergencyGradesMapper.getEmergencyMedicalServicesData(userTime);

        // 获取MedicalRecordsSectionData
        List<MedicalRecordsSectionDto> emergencyMedicalRecordsData = emergencyGradesMapper.getEmergencyMedicalRecordsData(userTime);

        // 获取并设置最终科室得分(比较质控单和申诉后得分)
        List<EmergencyFinalScoreDto> emergencyFinalScores = getEmergencyFinalScores(userTime);

        // 设置sumGradesForm（具体根据业务逻辑设置）
        List<SumEmergencyGradesDto> sumEmergencyGradesData = sumEMGrades(emergencyFinalScores, emergencyMedicalRecordsData, emergencyMedicalServicesData);

        //获取加分项
        List<BonusPointsProjectDto> emergencyBonusPointsData = emergencyGradesMapper.getEmergencyBonusPointsData(userTime);



        // 创建GradesFormDto对象并设置各个部分的数据
        EmergencyGradesDto emergencyGradesDto = new EmergencyGradesDto();
        emergencyGradesDto.setEmergencyMedicalServicesData(emergencyMedicalServicesData);
        emergencyGradesDto.setEmergencyMedicalRecordsData(emergencyMedicalRecordsData);
        emergencyGradesDto.setEmergencyFinalScores(emergencyFinalScores);
        emergencyGradesDto.setSumEmergencyGradesData(sumEmergencyGradesData);
        emergencyGradesDto.setEmergencyBonusPointsData(emergencyBonusPointsData);

        return emergencyGradesDto;
    }

    //对质控反馈单的最终得分进行判断
    public List<EmergencyFinalScoreDto> getEmergencyFinalScores(String userTime) {
        // 获取质控反馈单的分值
        List<EmergencyQcScoreDto> emergencyQcScoreData = emergencyGradesMapper.getEmergencyQcScoreData(userTime);
        // 获取反馈后的分数分值
        List<FinalScoreDto> emergencyFinalScoreData = emergencyGradesMapper.getEmergencyFinalScoreData(userTime);

        // 创建一个 HashMap 来存储 emergencyFinalScoreData 的内容
        Map<String, BigDecimal> emergencyFinalScoreMap = emergencyFinalScoreData.stream()
                .collect(Collectors.toMap(FinalScoreDto::getOfficeName, FinalScoreDto::getFinalScore));

        // 创建一个 List 来存储结果
        List<EmergencyFinalScoreDto> emergencyFinalScores = new ArrayList<>();

        // 遍历 emergencyQcScoreData
        for (EmergencyQcScoreDto emergencyQcScore : emergencyQcScoreData) {
            EmergencyFinalScoreDto emergencyFinalScoreDto = new EmergencyFinalScoreDto();  // 将变量名改为 emergencyFinalScoreDto
            emergencyFinalScoreDto.setOfficeName(emergencyQcScore.getOfficeName());
            // 从 HashMap 中查找 emergencyFinalScoreData，如果存在则使用，否则使用 emergencyQcScoreData
            emergencyFinalScoreDto.setEmergencyFinalScore(emergencyFinalScoreMap.getOrDefault(emergencyQcScore.getOfficeName(), emergencyQcScore.getEmergencyQcScore()));  // 将变量名改为 emergencyFinalScoreDto，set 方法也改为 setEmergencyFinalScore
            emergencyFinalScores.add(emergencyFinalScoreDto);  // 将变量名改为 emergencyFinalScoreDto
        }

        return emergencyFinalScores;
    }


    //计算hrp表单总分数
    public List<SumEmergencyGradesDto> sumEMGrades(List<EmergencyFinalScoreDto> emergencyFinalScores,
                                                   List<MedicalRecordsSectionDto> medicalRecordsSectionData,
                                                   List<MedicalServicesSectionDto> medicalServicesSectionData) {
        // 创建一个 HashMap，用于存储 officeName 对应的中间值
        Map<String, BigDecimal> intermediateScores = new HashMap<>();
        for (EmergencyFinalScoreDto emergencyFinalScore : emergencyFinalScores) {
            String officeName = emergencyFinalScore.getOfficeName();
            BigDecimal score = emergencyFinalScore.getEmergencyFinalScore();
            for (MedicalRecordsSectionDto medicalRecord : medicalRecordsSectionData) {
                if (officeName.equals(medicalRecord.getOfficeName())) {
                    score = score.add(medicalRecord.getMedicalRecordPageScore()); // 使用 add() 方法进行加法运算
                    break;
                }
            }
            intermediateScores.put(officeName, score);
        }

        // 创建一个 List，用于存储最终结果
        List<SumEmergencyGradesDto> sumEmergencyGradesDtos = new ArrayList<>();
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
            SumEmergencyGradesDto sumEmergencyGradesDto = new SumEmergencyGradesDto();
            sumEmergencyGradesDto.setOfficeName(officeName);
            sumEmergencyGradesDto.setSumEmergencyGrades(score); // 将变量名改为 setSumEmergencyGrades()
            sumEmergencyGradesDtos.add(sumEmergencyGradesDto); // 将变量名改为 sumEmergencyGradesDtos
        }
        return sumEmergencyGradesDtos;
    }



}
