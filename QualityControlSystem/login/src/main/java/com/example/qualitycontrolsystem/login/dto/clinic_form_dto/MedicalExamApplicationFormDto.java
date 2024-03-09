package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MedicalExamApplicationFormDto {




    @ExcelProperty("不合格例数")
    private Long unqualifiedCasesNumber;

    private Double failureRate;

    private Double pointsDeducted;




}
