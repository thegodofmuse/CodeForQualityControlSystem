package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;

import com.example.qualitycontrolsystem.login.dto.clinic_form_dto.BloodTransfusionRatioDto2;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BloodTransfusionRatioDto2Wrapper {
    private BloodTransfusionRatioDto2 data;

    public BloodTransfusionRatioDto2Wrapper(BloodTransfusionRatioDto2 data) {
        this.data = data;
    }

    public BloodTransfusionRatioDto2 getData() {
        return data;
    }

    public void setData(BloodTransfusionRatioDto2 data) {
        this.data = data;
    }
}