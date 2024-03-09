package com.example.qualitycontrolsystem.login.dto.hrp_dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BonusPointsProjectDto {
    @ExcelProperty("科室")
    private String officeName;
    @ExcelProperty("加分分数")
    private BigDecimal bonusPoints;
    @ExcelProperty("加分原因")
    private String bonusReason;
}
