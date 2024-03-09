package com.example.qualitycontrolsystem.login.entity.hrp_entity;


import lombok.Data;

@Data
public class GradesForm {
    private String officeName;

    private Double monthScore;

    private Double medTechServiceCapabilities;

    private Double prescriptiveTasks;

    private Double continuousImprovementMetrics;

    private Double medicalRecordPageScore;

    private Double qcOfficeScore;

    private Double qcFinalScore;


}
