package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExtendedHospitalStayManagementDto1 {


    @ExcelProperty("住院号")
    private Long admissionNumber;


    @ExcelProperty("有无阶段小结")
    private String stageSummary;

    @ExcelProperty("是否科室讨论")
    private String officeDiscuss;

    @ExcelProperty("是否科主任查房")
    private String directorRounds;


    @ExcelProperty("是否进行沟通")
    private String discuss;




}
