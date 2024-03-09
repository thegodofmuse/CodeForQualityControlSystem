package com.example.qualitycontrolsystem.login.dto.hrp_dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
//质控反馈单
@Data
public class QcSumScoreDto {
    private String officeName;

    private BigDecimal qcOfficeScore;

}
