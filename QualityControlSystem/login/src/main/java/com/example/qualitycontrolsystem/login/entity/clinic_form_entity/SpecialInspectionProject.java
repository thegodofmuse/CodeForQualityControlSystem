package com.example.qualitycontrolsystem.login.entity.clinic_form_entity;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class SpecialInspectionProject {

    @ExcelProperty("科室")
    private String officeName;

    @ExcelProperty("医生姓名")
    private String doctorName;

    @ExcelProperty("住院号")
    private Long admissionNumber;

    @ExcelProperty("本月重点督查")
    private String keyInspectionsThisMonth;

    @ExcelProperty("上月问题整改情况")
    private String rectificationStatusIssuesLastMonth;

    @ExcelProperty("用户时间")
    private LocalDateTime userTime;
}

