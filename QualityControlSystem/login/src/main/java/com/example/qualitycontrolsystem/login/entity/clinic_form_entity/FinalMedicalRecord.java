package com.example.qualitycontrolsystem.login.entity.clinic_form_entity;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class FinalMedicalRecord {

    @ExcelProperty("科室")
    private String officeName;

    @ExcelProperty("医生姓名")
    private String doctorName;

    @ExcelProperty("科室主任姓名")
    private String directorName;

    @ExcelProperty("病案号")
    private Long patientId;

    @ExcelProperty("有无乙级病历")
    private String gradeBMedicalRecord;

    @ExcelProperty("乙级病历医生被罚款")
    private Long gradeBMedicalRecordDoctorFine;

    @ExcelProperty("乙级病历主任被罚款")
    private Long gradeBMedicalRecordDirectorFine;

    @ExcelProperty("有无丙级病历")
    private String gradeCMedicalRecord;

    @ExcelProperty("丙级病历医生被罚款")
    private Long gradeCMedicalRecordDoctorFine;

    @ExcelProperty("丙级病历主任被罚款")
    private Long gradeCMedicalRecordDirectorFine;

    @ExcelProperty("罚款原因")
    private String fineReason;

    @ExcelProperty("用户时间")
    private LocalDateTime userTime;
}

