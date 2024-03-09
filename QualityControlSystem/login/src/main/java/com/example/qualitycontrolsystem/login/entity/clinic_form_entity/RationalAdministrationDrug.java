package com.example.qualitycontrolsystem.login.entity.clinic_form_entity;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class RationalAdministrationDrug {

    @ExcelProperty("考核项目")
    private String assessmentItems;

    @ExcelProperty("项目名称")
    private String projectName;

    @ExcelProperty("科室")
    private String officeName;

    @ExcelProperty("责任人")
    private String personResponsible;

    @ExcelProperty("住院号或门诊号")
    private String admissionOutpatientNum;

    @ExcelProperty("质控详情")
    private String qualityControlDetails;

    @ExcelProperty("考核结果")
    private String assessmentResults;

    @ExcelProperty("申诉")
    private String appeal;


    @ExcelProperty("用户时间")
    private LocalDateTime userTime;
}

