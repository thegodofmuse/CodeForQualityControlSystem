package com.example.qualitycontrolsystem.login.entity.hrp_entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
public class MedicalRecordsSection {
    @ExcelProperty("科室")
    private String officeName;

    @ExcelProperty("病案首页")
    private Double medicalRecordPageScore;

    @ExcelProperty("用户时间")
    private Date userTime;
}
