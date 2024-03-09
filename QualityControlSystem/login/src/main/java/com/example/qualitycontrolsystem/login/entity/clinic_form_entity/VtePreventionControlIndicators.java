package com.example.qualitycontrolsystem.login.entity.clinic_form_entity;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class VtePreventionControlIndicators {

    @ExcelProperty("科室")
    private String officeName;

    @ExcelProperty("VTE风险评估率")
    private BigDecimal vteRiskAssessmentRate;

    @ExcelProperty("VTE中高危患者出血风险评估率")
    private BigDecimal vteBleedingRiskAssessmentRate;

    @ExcelProperty("VTE中高危风险患者预防率")
    private BigDecimal vtePreventionRate;

    @ExcelProperty("用户时间")
    private LocalDateTime userTime;

}
