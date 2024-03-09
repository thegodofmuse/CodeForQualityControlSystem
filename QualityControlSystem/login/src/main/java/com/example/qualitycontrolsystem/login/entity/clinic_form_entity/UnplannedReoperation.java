package com.example.qualitycontrolsystem.login.entity.clinic_form_entity;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class UnplannedReoperation {

    @ExcelProperty("科室")
    private String officeName;

    @ExcelProperty("住院号")
    private Long admissionNumber;

    @ExcelProperty("病人姓名")
    private String patientName;

    @ExcelProperty("入院时间")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private LocalDateTime admissionTime;

    @ExcelProperty("性别")
    private String gender;

    @ExcelProperty("病人年龄")
    private int patientAge;

    @ExcelProperty("首次手术时间")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private LocalDateTime firstSurgeryTime;

    @ExcelProperty("再次手术时间")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private LocalDateTime secondSurgeryTime;

    @ExcelProperty("首次主刀医师")
    private String firstChiefSurgeon;

    @ExcelProperty("拟再次主刀医师")
    private String secondChiefSurgeon;

    @ExcelProperty("再次手术原因")
    private String secondSurgeonReason;

    @ExcelProperty("上报类型")
    private String reportType;

    @ExcelProperty("科主任是否查房")
    private String directorRounds;

    @ExcelProperty("有无讨论")
    private String discuss;

    @ExcelProperty("用户时间")
    private LocalDateTime userTime;
}
