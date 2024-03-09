package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class UnplannedReoperationDto2 {
    @ExcelProperty("住院号")
    private Long admissionNumber;

    @ExcelProperty("上报类型")
    private String reportType;

    @ExcelProperty("科主任是否查房")
    private String directorRounds;

    @ExcelProperty("有无讨论")
    private String discuss;

}
