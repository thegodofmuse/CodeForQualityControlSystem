package com.example.qualitycontrolsystem.login.dto.hrp_dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class MedicalServicesSectionDto {
    private String officeName;

    private BigDecimal medTechServiceCapabilities;

    private BigDecimal prescriptiveTasks;

    private BigDecimal continuousImprovementMetrics;

}
