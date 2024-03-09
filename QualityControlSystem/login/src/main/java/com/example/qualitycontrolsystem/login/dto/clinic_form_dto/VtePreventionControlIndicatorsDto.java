package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class VtePreventionControlIndicatorsDto {


    @ExcelProperty("VTE中高危患者出血风险评估率")
    private BigDecimal vteBleedingRiskAssessmentRate;

    @ExcelProperty("VTE中高危风险患者预防率")
    private BigDecimal vtePreventionRate;

    private Double pointsDeducted;



}
