package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BloodTransfusionRatioDto2 {
        @ExcelProperty("A型悬红")
        private BigDecimal aTypeSuspensionRed;

        @ExcelProperty("A型血浆")
        private BigDecimal aTypePlasma;

        @ExcelProperty("B型悬红")
        private BigDecimal bTypeSuspensionRed;

        @ExcelProperty("B型血浆")
        private BigDecimal bTypePlasma;

        @ExcelProperty("O型悬红")
        private BigDecimal oTypeSuspensionRed;

        @ExcelProperty("O型悬浆")
        private BigDecimal oTypePlasma;

        @ExcelProperty("AB型悬红")
        private BigDecimal abTypeSuspensionRed;

        @ExcelProperty("AB型悬浆")
        private BigDecimal abTypePlasma;

        @ExcelProperty("洗涤RBC")
        private BigDecimal washRbc;

        @ExcelProperty("解冻RBC")
        private BigDecimal thawRbc;

        @ExcelProperty("全血")
        private BigDecimal fullBlood;

        @ExcelProperty("单采血小板")
        private BigDecimal apheresisPlatelets;

        @ExcelProperty("冷沉淀")
        private BigDecimal cryoprecipitate;
    }



