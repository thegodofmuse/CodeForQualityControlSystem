package com.example.qualitycontrolsystem.login.dto.hrp_dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class MedicalRecordsSectionDto {
    private String officeName;
    private BigDecimal medicalRecordPageScore;
}
