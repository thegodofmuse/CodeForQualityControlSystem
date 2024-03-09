package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RationalAdministrationDrugDto {


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


}

