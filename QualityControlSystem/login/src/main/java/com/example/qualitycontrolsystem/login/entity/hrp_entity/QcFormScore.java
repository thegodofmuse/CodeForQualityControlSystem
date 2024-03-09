package com.example.qualitycontrolsystem.login.entity.hrp_entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class QcFormScore {
    private String officeName;
    private BigDecimal officeScore;
}
