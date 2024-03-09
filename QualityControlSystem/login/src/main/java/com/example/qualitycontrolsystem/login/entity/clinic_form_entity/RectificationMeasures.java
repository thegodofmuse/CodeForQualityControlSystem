package com.example.qualitycontrolsystem.login.entity.clinic_form_entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RectificationMeasures {
    @ExcelProperty("科室")
    private String officeName;

    @ExcelProperty("用户时间")
    private LocalDateTime userTime;

    @ExcelProperty("措施")
    private String measure;


}
