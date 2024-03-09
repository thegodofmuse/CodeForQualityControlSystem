package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShiftHandoverSystemDto {

    @ExcelProperty("交接班眉栏未填")
    private String eyebrowColumn;

    @ExcelProperty("交班内容不全")
    private String shiftContent;

    @ExcelProperty("接班内容不全")
    private String successionContent;

    @ExcelProperty("未体现床旁交接班")
    private String bedsideHandover;

    @ExcelProperty("交班医生没签名")
    private String shiftDoctorSign;

    @ExcelProperty("接班医生没签名")
    private String successDoctorSign;

    private Double pointsDeducted;


}