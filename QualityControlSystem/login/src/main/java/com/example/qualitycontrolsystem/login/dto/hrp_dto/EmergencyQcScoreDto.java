package com.example.qualitycontrolsystem.login.dto.hrp_dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class EmergencyQcScoreDto {
    private String officeName;

    private BigDecimal emergencyQcScore;
}
