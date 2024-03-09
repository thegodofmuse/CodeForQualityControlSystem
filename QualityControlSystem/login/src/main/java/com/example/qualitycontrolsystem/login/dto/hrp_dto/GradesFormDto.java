package com.example.qualitycontrolsystem.login.dto.hrp_dto;

import lombok.Data;

import java.util.List;

@Data
public class GradesFormDto {
    //医务科+病案科
    private List<MedicalServicesSectionDto>medicalServicesSectionData;
    private List<MedicalRecordsSectionDto>medicalRecordsSectionData;

    //质控反馈单
    private List<QcSumScoreDto>qcSumScoreData;
    private List<FinalScoreDto>finalScoreData;

    // finalOfficeScores属性的定义（比较质控反馈单和申诉后得分）
    private List<FinalOfficeScoreDto> finalOfficeScores;

    public List<FinalOfficeScoreDto> getFinalOfficeScores() {
        return finalOfficeScores;
    }

    public void setFinalOfficeScores(List<FinalOfficeScoreDto> finalOfficeScores) {
        this.finalOfficeScores = finalOfficeScores;
    }

    //hrp表单总分
    private List<SumGradesFormDto> sumGradesFormData;

    //加分项
    private List<BonusPointsProjectDto>bonusPointsProjectData;


}
