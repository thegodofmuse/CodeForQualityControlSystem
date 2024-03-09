package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TimelinessOfWritingDto1 {

    @ExcelProperty("住院号")
    private Long admissionNumber;

    @ExcelProperty("主管医师")
    private String doctorName;

    @ExcelProperty("质控项目")
    private String projectName;

    @ExcelProperty("质控结果")
    private String qcResult;



}
