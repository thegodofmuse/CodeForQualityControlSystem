package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BloodTransfusionRelatedRecordsDto {

    @ExcelProperty("主管医生")
    private String zhuguanDoctorName;

    @ExcelProperty("住院号")
    private Long admissionNumber;

    @ExcelProperty("主要缺陷")
    private String majorDefect;

    @ExcelProperty("扣分")
    private BigDecimal pointsDeducted;


}

