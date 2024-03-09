package com.example.qualitycontrolsystem.login.dto.view_dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class VteBleedOfficeTrendDto {
    private BigDecimal vteBleedingRiskAssessmentRate;
    private int month;
}
