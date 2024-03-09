package com.example.qualitycontrolsystem.login.entity.clinic_form_entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ObstetricSpecial {
    @ExcelProperty("科室")
    private String officeName;

    @ExcelProperty("纯母乳喂养率")
    private double exclusiveBreastfeeding;

    @ExcelProperty("非医学指征剖宫产率")
    private double abnormalCesarean;

    @ExcelProperty("剖宫产率")
    private double cesarean;

    @ExcelProperty("阴道分娩并发症")
    private double complicationsOfVaginalDelivery;

    @ExcelProperty("用户时间")
    private Date userTime;
}
