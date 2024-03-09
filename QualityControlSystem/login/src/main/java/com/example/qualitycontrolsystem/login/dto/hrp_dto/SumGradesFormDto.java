package com.example.qualitycontrolsystem.login.dto.hrp_dto;

import lombok.Data;

import java.math.BigDecimal;

//hrp表单总分
@Data
public class SumGradesFormDto {
    private String officeName;
    private BigDecimal sumGrades;
}
