package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ExtendedHospitalStayManagementDto2 {


    @ExcelProperty("医生姓名")
    private String doctorName;

    @ExcelProperty("住院号")
    private Long admissionNumber;


    private String reportType;
    private Double pointsDeducted;

}
