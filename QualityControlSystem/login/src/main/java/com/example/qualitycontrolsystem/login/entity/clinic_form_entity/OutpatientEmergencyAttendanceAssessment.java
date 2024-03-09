package com.example.qualitycontrolsystem.login.entity.clinic_form_entity;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class OutpatientEmergencyAttendanceAssessment {

    @ExcelProperty("科室")
    private String officeName;

    @ExcelProperty("医生姓名")
    private String doctorName;

    @ExcelProperty("门诊和急诊考勤")
    private String outpatientEmergencyAttendance;

    @ExcelProperty("扣分")
    private Double pointsDeducted;

    @ExcelProperty("用户时间")
    private LocalDateTime userTime;
}
