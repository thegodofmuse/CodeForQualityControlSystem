package com.example.qualitycontrolsystem.login.entity.clinic_form_entity;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class MedicalExamApplicationFormFail {

    @ExcelProperty("病人姓名")
    private String patientName;

    @ExcelProperty("科室")
    private String officeName;

    @ExcelProperty("医生姓名")
    private String doctorName;

    @ExcelProperty("接收时间")
    private LocalDateTime receptionTime;

    @ExcelProperty("申请单填写是否规范")
    private String applicationFormSpecification;

    @ExcelProperty("有无医嘱")
    private String doctorAdvice;

    @ExcelProperty("是否填写标本固定时间")
    private String specimenFixationTime;

    @ExcelProperty("标本是否添加固定液")
    private String addSampleFixationSolution;

    @ExcelProperty("用户时间")
    private LocalDateTime userTime;
}
