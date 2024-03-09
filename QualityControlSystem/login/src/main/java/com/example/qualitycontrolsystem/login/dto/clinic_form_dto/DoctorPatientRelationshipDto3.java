package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class DoctorPatientRelationshipDto3 {
    @ExcelProperty("被考核人")
    private String assessee;

    @ExcelProperty("患者姓名/病历号")
    private String patientNameNum;

    @ExcelProperty("质控详情")
    private String qualityControlDetails;

    @ExcelProperty("考核结果")
    private String assessmentResults;
}
