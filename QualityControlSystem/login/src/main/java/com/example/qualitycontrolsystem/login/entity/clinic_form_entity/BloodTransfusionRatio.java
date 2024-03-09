package com.example.qualitycontrolsystem.login.entity.clinic_form_entity;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BloodTransfusionRatio {

        @ExcelProperty("科室")
        private String officeName;

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

        @ExcelProperty("O型血浆")
        private BigDecimal oTypePlasma;

        @ExcelProperty("AB型悬红")
        private BigDecimal abTypeSuspensionRed;

        @ExcelProperty("AB型血浆")
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

        @ExcelProperty("成分血比例")
        private String componentBloodRatio;

        @ExcelProperty("用户时间")
        private LocalDateTime userTime;


    }



