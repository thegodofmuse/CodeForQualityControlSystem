package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostoperativeComplicationsDto {



    @ExcelProperty("住院号")
    private Long admissionNumber;




}
