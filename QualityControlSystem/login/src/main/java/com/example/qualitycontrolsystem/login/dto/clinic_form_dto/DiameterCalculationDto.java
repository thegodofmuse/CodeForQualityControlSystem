package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class DiameterCalculationDto {
    private BigDecimal completionRate;
    private BigDecimal enrollmentRate;
    private BigDecimal entryRate;
    private Integer pointsDeducted;
}
