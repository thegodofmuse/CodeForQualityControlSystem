package com.example.qualitycontrolsystem.login.dto.view_dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class VteBleedMonthDto {
    private String officeName;
    private BigDecimal vteBleedingRiskAssessmentRate;

}
