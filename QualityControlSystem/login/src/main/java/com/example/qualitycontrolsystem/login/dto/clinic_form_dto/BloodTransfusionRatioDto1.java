package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BloodTransfusionRatioDto1 {

        @ExcelProperty("成分血比例")
        private String componentBloodRatio;


    }



