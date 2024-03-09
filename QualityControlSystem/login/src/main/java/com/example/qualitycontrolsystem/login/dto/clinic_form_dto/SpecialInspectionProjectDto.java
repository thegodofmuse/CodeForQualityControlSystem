package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SpecialInspectionProjectDto {





    private String doctorName;


    private Long admissionNumber;


    private String keyInspectionsThisMonth;
    private String rectificationStatusIssuesLastMonth;


}

