package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class QcRectificationSituationDto {
    @ExcelProperty("整改情况")
    private String rectificationSituation;
}
