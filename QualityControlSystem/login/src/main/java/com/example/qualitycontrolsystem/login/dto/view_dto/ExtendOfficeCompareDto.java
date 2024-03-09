package com.example.qualitycontrolsystem.login.dto.view_dto;

import lombok.Data;

import java.util.List;

@Data
public class ExtendOfficeCompareDto {
    private int month;
    private int count;
    private String yearType;
    private List<Double> countList;
}
