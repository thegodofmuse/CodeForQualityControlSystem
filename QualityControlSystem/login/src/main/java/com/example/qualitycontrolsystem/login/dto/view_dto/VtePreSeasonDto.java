package com.example.qualitycontrolsystem.login.dto.view_dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class VtePreSeasonDto {
    private String officeName;
    private BigDecimal vtePreventionRate;
    private int month;
    private List<Double> vtePreventionRateArray;
}
