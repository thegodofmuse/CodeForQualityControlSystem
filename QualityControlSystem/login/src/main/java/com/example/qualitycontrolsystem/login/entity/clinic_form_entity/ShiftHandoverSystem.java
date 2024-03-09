package com.example.qualitycontrolsystem.login.entity.clinic_form_entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ShiftHandoverSystem {

    @ExcelProperty("科室")
    private String officeName;

    @ExcelProperty("扣分")
    private Double pointsDeducted;

    @ExcelProperty("交接班眉栏未填")
    private String eyebrowColumn;

    @ExcelProperty("交班内容不全")
    private String shiftContent;

    @ExcelProperty("接班内容不全")
    private String successionContent;

    @ExcelProperty("未体现床旁交接班")
    private String bedsideHandover;

    @ExcelProperty("交班医生没签名")
    private String shiftDoctorSign;

    @ExcelProperty("接班医生没签名")
    private String successDoctorSign;

    @ExcelProperty("用户时间")
    private Date userTime;
}