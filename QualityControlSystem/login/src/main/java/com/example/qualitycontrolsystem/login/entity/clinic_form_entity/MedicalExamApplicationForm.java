package com.example.qualitycontrolsystem.login.entity.clinic_form_entity;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class MedicalExamApplicationForm {

    @ExcelProperty("科室")
    private String officeName;

    @ExcelProperty("送检总例数")
    private Long medicalExamNumber;

    @ExcelProperty("不合格例数")
    private Long unqualifiedCasesNumber;

    @ExcelProperty("不合格原因")
    private String failReason;

    @ExcelProperty("用户时间")
    private LocalDateTime userTime;
}
