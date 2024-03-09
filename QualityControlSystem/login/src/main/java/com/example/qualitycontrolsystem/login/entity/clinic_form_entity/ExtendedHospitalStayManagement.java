package com.example.qualitycontrolsystem.login.entity.clinic_form_entity;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExtendedHospitalStayManagement {

    @ExcelProperty("科室")
    private String officeName;

    @ExcelProperty("医生姓名")
    private String doctorName;

    @ExcelProperty("住院号")
    private Long admissionNumber;

    @ExcelProperty("病人姓名")
    private String patientName;

    @ExcelProperty("上报时间节点")
    private LocalDateTime reportingTimeNode;

    @ExcelProperty("上报时间")
    private LocalDateTime reportingTime;


    @ExcelProperty("有无阶段小结")
    private String stageSummary;

    @ExcelProperty("是否科主任查房")
    private String directorRounds;

    @ExcelProperty("是否科室讨论")
    private String officeDiscuss;


    @ExcelProperty("是否进行沟通")
    private String discuss;

    @ExcelProperty("是否涉及转科")
    private String transferOffice;

    @ExcelProperty("住院超30天原因")
    private String extendedHospitalStayReason;

    @ExcelProperty("病历缺陷")
    private String medicalRecordDefects;

    @ExcelProperty("用户时间")
    private LocalDateTime userTime;


}
