package com.example.qualitycontrolsystem.login.entity.clinic_form_entity;
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
public class MqManagementTeamOffice {

    @ExcelProperty("科室")
    @TableField(value = "office_name")
    private String officeName;

    @ExcelProperty("开会时间")
    @TableField(value = "meeting_time")
    private Date meetingTime;

    @ExcelProperty("质控资料上传时间")
    @TableField(value = "qc_data_upload_time")
    private Date qcDataUploadTime;

    @ExcelProperty("是否使用管理工具")
    @TableField(value = "user_administrative_tools")
    private String userAdministrativeTools;

    @ExcelProperty("是否有持续改进效果")
    @TableField(value = "continuous_improvement_effect")
    private String continuousImprovementEffect;

    @ExcelProperty("内容是否完整")
    @TableField(value = "content_complete")
    private String contentComplete;

    @ExcelProperty("日常管理活动")
    @TableField(value = "daily_management_activities")
    private String dailyManagementActivities;

    @ExcelProperty("本月缺陷总结")
    @TableField(value = "sum_defects_month")
    private String sumDefectsMonth;

    @ExcelProperty("本月整改措施")
    @TableField(value = "correctiveaction_this_month")
    private String correctiveActionThisMonth;

    @ExcelProperty("上月缺陷整改情况")
    @TableField(value = "rectification_defects_last_month")
    private String rectificationDefectsLastMonth;

    @ExcelProperty("扣分")
    @TableField(value = "points_deducted")
    private Double pointsDeducted;

    @ExcelProperty("用户时间")
    @TableField(value = "user_time")
    private LocalDateTime userTime;
}




