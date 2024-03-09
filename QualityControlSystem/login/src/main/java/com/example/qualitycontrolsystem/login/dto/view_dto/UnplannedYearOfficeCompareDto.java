package com.example.qualitycontrolsystem.login.dto.view_dto;

import lombok.Data;

import java.util.List;

@Data
public class UnplannedYearOfficeCompareDto {
    private String officeName;
    private List<Double> countArray;
    private Double countYear;
    private Double countPrevYear;
}
