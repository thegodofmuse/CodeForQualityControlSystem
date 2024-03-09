package com.example.qualitycontrolsystem.login.entity.clinic_form_entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BloodTransfusionRelatedRecords {

    @ExcelProperty("科室")
    private String officeName;

    @ExcelProperty("病人姓名")
    private String patientName;

    @ExcelProperty("主管医生")
    private String zhuguanDoctorName;

    @ExcelProperty("病案号")
    private Long patientId;

    @ExcelProperty("住院号")
    private Long admissionNumber;

    @ExcelProperty("主要缺陷")
    private String majorDefect;

    @ExcelProperty("扣分")
    private BigDecimal pointsDeducted;

    @ExcelProperty("用户时间")
    private LocalDateTime userTime;
}

