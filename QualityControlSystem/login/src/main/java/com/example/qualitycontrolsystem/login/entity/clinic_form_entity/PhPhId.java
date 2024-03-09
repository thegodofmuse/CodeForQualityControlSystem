package com.example.qualitycontrolsystem.login.entity.clinic_form_entity;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class PhPhId {

    @ExcelProperty("科室")
    private String officeName;

    @ExcelProperty("病区健康教育问题反馈")
    private String wardHealthEducation;

    @ExcelProperty("死因监测工作中问题反馈")
    private String deathMonitoringWork;

    @ExcelProperty("疫苗及冷链相关工作中问题反馈")
    private String vaccinesAndColdChain;

    @ExcelProperty("食源性疾病监测工作问题反馈")
    private String foodborneDiseaseMonitoring;

    @ExcelProperty("传染病上报管理工作中问题反馈")
    private String infectiousDiseaseReporting;

    @ExcelProperty("妇幼工作中问题反馈")
    private String maternalChildWork;

    @ExcelProperty("公共卫生科建卷专项检查")
    private String publicHealthCheck;

    @ExcelProperty("用户时间")
    private LocalDateTime userTime;
}
