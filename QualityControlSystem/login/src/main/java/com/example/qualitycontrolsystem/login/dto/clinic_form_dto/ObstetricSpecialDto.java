package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ObstetricSpecialDto {
    @ExcelProperty("纯母乳喂养率")
    private double exclusiveBreastfeeding;

    @ExcelProperty("非医学指征剖宫产率")
    private double abnormalCesarean;

    @ExcelProperty("剖宫产率")
    private double cesarean;

    @ExcelProperty("阴道分娩并发症")
    private double complicationsOfVaginalDelivery;
}
