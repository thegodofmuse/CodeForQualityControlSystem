package com.example.qualitycontrolsystem.login.entity.clinic_form_entity;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class DifficultCaseDiscussionSystem {
    @ExcelProperty("科室")
    private String officeName;

    @ExcelProperty("扣分")
    private Double pointsDeducted;

    @ExcelProperty("是否进行疑难讨论")
    private String difficultDiscussion;

    @ExcelProperty("是否讨论非计划再手术")
    private String unplannedReoperation;

    @ExcelProperty("是否已讨论术后并发症")
    private String postoperativeCom;

    @ExcelProperty("讨论病历类型")
    private String medicalRecordType;

    @ExcelProperty("参加人员是否欠缺")
    private String participation;

    @ExcelProperty("参与者是否签署职称")
    private String signedTitle;

    @ExcelProperty("参与者是否签字")
    private String participationSigned;

    @ExcelProperty("发言顺序是否规范")
    private String speechOrder;

    @ExcelProperty("是否粘贴规范")
    private String paste;

    @ExcelProperty("是否手写具体讨论意见")
    private String discussionOpinions;

    @ExcelProperty("主持人是否签字")
    private String hostSigned;

    @ExcelProperty("记录人是否签字")
    private String recorderSigned;

    @ExcelProperty("是否明确诊断")
    private String deathDiagnosis;

    @ExcelProperty("是否提出解决方案")
    private String solution;

    @ExcelProperty("是否签字潦草")
    private String scrawledSignature;

    @ExcelProperty("用户时间")
    private Date userTime;
}