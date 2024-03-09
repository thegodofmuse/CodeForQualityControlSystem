package com.example.qualitycontrolsystem.login.entity.clinic_form_entity;

import com.alibaba.excel.annotation.ExcelProperty;

import java.time.LocalDateTime;
import lombok.Data;
@Data
public class EmergencyMedicalRecords {

    @ExcelProperty("科室")
    private String officeName;

    @ExcelProperty("病历类型")
    private String recordsType;

    @ExcelProperty("医生姓名")
    private String doctorName;

    @ExcelProperty("门诊号")
    private String outpatientNumber;

    @ExcelProperty("结论")
    private String summary;

    @ExcelProperty("无病历")
    private Double medicalRecordsScore;

    @ExcelProperty("病历缺陷")
    private Double missingMedicalRecordsScore;

    @ExcelProperty("主诉无时间")
    private Double chiefComplaintWithoutTimeScore;

    @ExcelProperty("现病史复制主诉")
    private Double replicatesChiefComplaintScore;

    @ExcelProperty("主诉与现病史不符")
    private Double chiefComplaintInconsistencyScore;

    @ExcelProperty("无重要症状体征")
    private Double noSignificantSymptomsOrSignsScore;

    @ExcelProperty("无体征")
    private Double noPhysicalSignsScore;

    @ExcelProperty("纠纷")
    private Double disputeScore;

    @ExcelProperty("用户时间")
    private LocalDateTime userTime;


}
