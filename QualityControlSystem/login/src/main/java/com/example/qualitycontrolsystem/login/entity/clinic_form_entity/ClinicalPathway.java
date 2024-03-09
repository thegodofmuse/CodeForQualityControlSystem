package com.example.qualitycontrolsystem.login.entity.clinic_form_entity;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ClinicalPathway {

    @ExcelProperty("科室")
    private String officeName;

    @ExcelProperty("入径病种")
    private String invasiveDiseaseSpecies;

    @ExcelProperty("入径人数")
    private Long numberOfEntrants;

    @ExcelProperty("完成人数")
    private Long numOfFinish;

    @ExcelProperty("退出人数")
    private Long numOfExits;

    @ExcelProperty("变异人数")
    private Long numOfVariants;

    @ExcelProperty("死亡")
    private Long deathNumber;

    @ExcelProperty("未入人数")
    private Long noEnterNum;

    @ExcelProperty("用户时间")
    private LocalDateTime userTime;
}
