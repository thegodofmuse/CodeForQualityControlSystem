package com.example.qualitycontrolsystem.login.dto.hrp_dto;

import lombok.Data;

import java.math.BigDecimal;
//质控反馈单总分设置
@Data
public class QcFormDto {
    private String officeName;
    private BigDecimal officeScore;

    public QcFormDto(String officeName, BigDecimal officeScore) {
        this.officeName = officeName;
        this.officeScore = officeScore;
    }
}