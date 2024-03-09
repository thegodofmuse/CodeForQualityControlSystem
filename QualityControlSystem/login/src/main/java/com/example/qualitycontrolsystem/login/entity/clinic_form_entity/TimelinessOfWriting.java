package com.example.qualitycontrolsystem.login.entity.clinic_form_entity;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TimelinessOfWriting {
    @ExcelProperty("住院号")
    private Long admissionNumber;

    @ExcelProperty("科室")
    private String officeName;

    @ExcelProperty("主管医师")
    private String doctorName;

    @ExcelProperty("质控项目")
    private String projectName;

    @ExcelProperty("质控结果")
    private String qcResult;

    @ExcelProperty("用户时间")
    private LocalDateTime userTime;

}
