package com.example.qualitycontrolsystem.login.entity.clinic_form_entity;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class SingleDisease {

    @ExcelProperty("科室")
    private String officeName;

    @ExcelProperty("病例上报率")
    private BigDecimal reportingRate;


    @ExcelProperty("用户时间")
    private LocalDateTime userTime;
}
