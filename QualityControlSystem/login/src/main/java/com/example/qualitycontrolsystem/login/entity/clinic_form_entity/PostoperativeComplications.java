package com.example.qualitycontrolsystem.login.entity.clinic_form_entity;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class PostoperativeComplications {

    @ExcelProperty("病人姓名")
    private String patientName;

    @ExcelProperty("住院号")
    private Long admissionNumber;

    @ExcelProperty("病案号")
    private Long patientId;

    @ExcelProperty("出院科室")
    private String dischargeOffice;

    @ExcelProperty("出院日期")
    private LocalDateTime dischargeDate;

    @ExcelProperty("离院方式")
    private String departureMethod;

    @ExcelProperty("疾病代码")
    private String diseaseCode;

    @ExcelProperty("亚目")
    private String suborder;

    @ExcelProperty("疾病名称")
    private String diseaseName;

    @ExcelProperty("入院病情")
    private String admissionCondition;

    @ExcelProperty("疾病序号")
    private String diseaseSerialNumber;

    @ExcelProperty("手术操作编码")
    private String operationCode;

    @ExcelProperty("手术操作")
    private String operation;

    @ExcelProperty("手术日期")
    private LocalDateTime operationDate;

    @ExcelProperty("是否择期")
    private String selective;

    @ExcelProperty("是否为并发症标准")
    private String complicationsDescription;

    @ExcelProperty("用户时间")
    private LocalDateTime userTime;
}
