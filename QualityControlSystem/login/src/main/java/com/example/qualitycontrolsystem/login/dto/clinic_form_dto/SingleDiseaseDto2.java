package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SingleDiseaseDto2 {
    @ExcelProperty("上报率")
    private BigDecimal reportingRate;

    private BigDecimal pointsDeducted;

}
