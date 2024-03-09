package com.example.qualitycontrolsystem.login.entity.hrp_entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class BonusPointsProject {
    @ExcelProperty("科室")
    private String officeName;
    @ExcelProperty("加分分数")
    private Double bonusPoints;
    @ExcelProperty("加分原因")
    private String bonusReason;
    @ExcelProperty("用户时间")
    private String userTime;
}
