package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeathCaseDiscussionSystemDto {
    @ExcelProperty(value = "是否有死亡病人")
    private String hasCaseDeath;

    @ExcelProperty(value = "是否一周内完成死亡病例讨论")
    private String hasRecord;

    @ExcelProperty(value = "参与人员是否欠缺")
    private String participation;

    @ExcelProperty(value = "参与者是否签署职称")
    private String signedTitle;

    @ExcelProperty(value = "参与者是否签字")
    private String participationSigned;

    @ExcelProperty(value = "发言顺序是否规范")
    private String speechOrder;

    @ExcelProperty(value = "粘贴是否规范")
    private String paste;

    @ExcelProperty(value = "是否手写具体讨论意见")
    private String discussionOpinions;

    @ExcelProperty(value = "主持人是否签字")
    private String hostSigned;

    @ExcelProperty(value = "记录人是否签字")
    private String recorderSigned;

    @ExcelProperty(value = "是否明确死亡诊断")
    private String deathDiagnosis;

    @ExcelProperty(value = "是否总结经验教训")
    private String sumExperience;

    @ExcelProperty(value = "是否签字潦草")
    private String scrawledSignature;


    private Double pointsDeducted;


}
