package com.example.qualitycontrolsystem.login.dto.view_dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class VteBleedSeasonDto {
    private String officeName;
    private BigDecimal vteBleedingRiskAssessmentRate;
    private int month;
    private List<Double> vteBleedingRiskAssessmentRateArray;
}
