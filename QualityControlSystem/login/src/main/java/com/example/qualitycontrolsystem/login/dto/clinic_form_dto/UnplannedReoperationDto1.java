package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class UnplannedReoperationDto1 {
    //统计有几例非计划手术
    private int totalCount;
    //计算分数
    private Double deductedTotal;
}
