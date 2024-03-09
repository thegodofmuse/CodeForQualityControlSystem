package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("mq_management_team_office")
public class MqManagementTeamOfficeDto {


    @ExcelProperty("质控资料上传时间")
    @TableField(value = "qc_data_upload_time")
    private Date qcDataUploadTime;

    @TableField(value = "user_administrative_tools")
    private String userAdministrativeTools;


    @TableField(value = "continuous_improvement_effect")
    private String continuousImprovementEffect;



    @TableField(value = "points_deducted")
    private Double pointsDeducted;


}




