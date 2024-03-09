package com.example.qualitycontrolsystem.login.entity.hrp_entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class MedicalServicesSection {
    @ExcelProperty("科室")
    private String officeName;

    @ExcelProperty("医疗技术及服务能力")
    private Double medTechServiceCapabilities;

    @ExcelProperty("指令性任务")
    private Double prescriptiveTasks;

    @ExcelProperty("持续改进指标")
    private Double continuousImprovementMetrics;

    @ExcelProperty("用户时间")
    private Date userTime;
}
