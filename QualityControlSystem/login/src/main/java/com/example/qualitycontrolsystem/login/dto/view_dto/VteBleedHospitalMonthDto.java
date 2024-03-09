package com.example.qualitycontrolsystem.login.dto.view_dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class VteBleedHospitalMonthDto {
    private BigDecimal averageRate;
    private int month;
}
