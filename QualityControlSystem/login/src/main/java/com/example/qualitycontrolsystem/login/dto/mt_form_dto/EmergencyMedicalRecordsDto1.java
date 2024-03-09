package com.example.qualitycontrolsystem.login.dto.mt_form_dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class EmergencyMedicalRecordsDto1 {
    @ExcelProperty("医生姓名")
    private String doctorName;

    @ExcelProperty("门诊号")
    private String outpatientNumber;

    @ExcelProperty("结论")
    private String summary;
    private Double totalDeductionPoints;
}
