package com.example.qualitycontrolsystem.login.dto.hrp_dto;

import lombok.Data;

import java.util.List;

@Data
public class EmergencyGradesDto {
    //医务科+病案科
    private List<MedicalServicesSectionDto>emergencyMedicalServicesData;
    private List<MedicalRecordsSectionDto>emergencyMedicalRecordsData;

    //急诊科质控反馈单
    private List<EmergencyQcScoreDto>emergencyQcScoreData;
    private List<FinalScoreDto>emergencyFinalScoreData;

    // emergencyFinalScores属性的定义（比较质控反馈单和申诉后得分）
    private List<EmergencyFinalScoreDto> emergencyFinalScores;

    public List<EmergencyFinalScoreDto> getEmergencyFinalScores() {
        return emergencyFinalScores;
    }

    public void setEmergencyFinalScores(List<EmergencyFinalScoreDto> emergencyFinalScores) {
        this.emergencyFinalScores = emergencyFinalScores;
    }

    //hrp表单总分
    private List<SumEmergencyGradesDto> sumEmergencyGradesData;

    //加分项
    private List<BonusPointsProjectDto>emergencyBonusPointsData;

}
