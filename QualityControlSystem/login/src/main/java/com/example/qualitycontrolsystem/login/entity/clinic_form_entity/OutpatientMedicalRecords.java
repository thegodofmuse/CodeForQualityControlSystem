package com.example.qualitycontrolsystem.login.entity.clinic_form_entity;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class OutpatientMedicalRecords {

    @ExcelProperty("科室")
    private String officeName;

    @ExcelProperty("医生姓名")
    private String doctorName;

    @ExcelProperty("门诊号")
    private String outpatientNumber;


    @ExcelProperty("结论")
    private String summary;

    @ExcelProperty("无病历")
    private Double medicalRecordsScore;

//    @ExcelProperty("病历缺陷")
//    private Double missingMedicalRecordsScore;

    @ExcelProperty("主诉无时间")
    private Double chiefComplaintWithoutTimeScore;

    @ExcelProperty("现病史复制主诉")
    private Double replicatesChiefComplaintScore;

    @ExcelProperty("病史体征诊断符合度")
    private Double physicalSignsDiagnosisScore;

    @ExcelProperty("无重要生命体征")
    private Double noSignificantVitalSignsScore;

    @ExcelProperty("无体征")
    private Double noPhysicalSignsScore;

    @ExcelProperty("纠纷")
    private Double disputeScore;

    @ExcelProperty("用户时间")
    private LocalDateTime userTime;
}
