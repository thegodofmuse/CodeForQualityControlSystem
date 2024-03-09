package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class RectificationMeasuresDto {
    @ExcelProperty("措施")
    private String measure;

}
