package com.example.qualitycontrolsystem.login.dto.view_dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class VteBleedHospitalSeasonDto {
    private int quarter;
    private BigDecimal averageRate;
}
