package com.example.qualitycontrolsystem.login.entity.clinic_form_entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class DoctorPatientRelationship {

    @ExcelProperty("考核项目")
    private String assessmentItems;

    @ExcelProperty("科室")
    private String officeName;

    @ExcelProperty("被考核人")
    private String assessee;

    @ExcelProperty("患者姓名/病历号")
    private String patientNameNum;

    @ExcelProperty("质控详情")
    private String qualityControlDetails;

    @ExcelProperty("考核结果")
    private String assessmentResults;

    @ExcelProperty("扣分")
    private BigDecimal pointsDeducted;

    @ExcelProperty("用户时间")
    private LocalDateTime userTime;
}
