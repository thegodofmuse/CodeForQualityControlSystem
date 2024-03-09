package com.example.qualitycontrolsystem.login.mapper.hrp_mapper;

import com.example.qualitycontrolsystem.login.dto.hrp_dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GradesFormMapper {
    @Select("SELECT m.office_name, m.med_tech_service_capabilities, m.prescriptive_tasks, m.continuous_improvement_metrics " +
            "FROM office_list o " +
            "JOIN medical_services_section m ON o.office_name = m.office_name " +
            "WHERE m.user_time = #{userTime}")
    List<MedicalServicesSectionDto> getMedicalServicesSectionData(@Param("userTime") String userTime);

    @Select("SELECT m.office_name, m.medical_record_page_score " +
            "FROM office_list o " +
            "JOIN medical_records_section m ON o.office_name = m.office_name " +
            "WHERE m.user_time = #{userTime}")
    List<MedicalRecordsSectionDto> getMedicalRecordsSectionData(@Param("userTime") String userTime);

    @Select("SELECT qc.office_name, " +
            "(qc.office_score - COALESCE(mq.points_deducted, 0) - COALESCE(shs.points_deducted, 0) - COALESCE(dcds.points_deducted, 0) - COALESCE(deathcds.points_deducted, 0) - COALESCE(omr.total_deduction_points, 0) - COALESCE(ehsm.total_points_deducted, 0) - COALESCE(vte.points_deducted, 0) - COALESCE(ur.deducted_total, 0) - COALESCE(meaf.points_deducted, 0) - COALESCE(dc.points_deducted, 0) - COALESCE(sd.points_deducted, 0) - COALESCE(btrr.total_points_deducted, 0) - COALESCE(dpr.total_points_deducted, 0)) AS qc_office_score " +
            "FROM qc_form_score qc " +
            "LEFT JOIN mq_management_team_office mq ON qc.office_name = mq.office_name AND mq.user_time = #{userTime} " +
            "LEFT JOIN shift_handover_system shs ON qc.office_name = shs.office_name AND shs.user_time = #{userTime} " +
            "LEFT JOIN difficult_case_discussion_system dcds ON qc.office_name = dcds.office_name AND dcds.user_time = #{userTime} " +
            "LEFT JOIN death_case_discussion_system deathcds ON qc.office_name = deathcds.office_name AND deathcds.user_time = #{userTime} " +
            "LEFT JOIN ( " +
            "    SELECT office_name, SUM(total_deduction_points) AS total_deduction_points " +
            "    FROM outpatient_medical_records " +
            "    WHERE user_time = #{userTime} " +
            "    GROUP BY office_name " +
            ") omr ON qc.office_name = omr.office_name " +
            "LEFT JOIN ( " +
            "    SELECT office_name, SUM(points_deducted) AS total_points_deducted " +
            "    FROM extended_hospital_stay_management " +
            "    WHERE user_time = #{userTime} " +
            "    GROUP BY office_name " +
            ") ehsm ON qc.office_name = ehsm.office_name " +
            "LEFT JOIN vte_prevention_control_indicators vte ON qc.office_name = vte.office_name AND vte.user_time = #{userTime} " +
            "LEFT JOIN ( " +
            "    SELECT office_name, IFNULL(SUM(points_deducted), 0) AS deducted_total " +
            "    FROM unplanned_reoperation " +
            "    WHERE user_time = #{userTime} " +
            "    GROUP BY office_name " +
            ") ur ON qc.office_name = ur.office_name " +
            "LEFT JOIN medical_exam_application_form meaf ON qc.office_name = meaf.office_name AND meaf.user_time = #{userTime} " +
            "LEFT JOIN diameter_calculation dc ON qc.office_name = dc.office_name AND dc.user_time = #{userTime} " +
            "LEFT JOIN single_disease sd ON qc.office_name = sd.office_name AND sd.user_time = #{userTime} " +
            "LEFT JOIN ( " +
            "    SELECT office_name, SUM(points_deducted) AS total_points_deducted " +
            "    FROM blood_transfusion_related_records " +
            "    WHERE user_time = #{userTime} " +
            "    GROUP BY office_name " +
            ") btrr ON qc.office_name = btrr.office_name " +
            "LEFT JOIN ( " +
            "    SELECT office_name, SUM(points_deducted) AS total_points_deducted " +
            "    FROM doctor_patient_relationship " +
            "    WHERE user_time = #{userTime} " +
            "    GROUP BY office_name " +
            ") dpr ON qc.office_name = dpr.office_name")
    List<QcSumScoreDto> getQcSumScoreData(@Param("userTime") String userTime);


    @Select("SELECT office_name, final_score " +
            "FROM qc_form_feedback_score " +
            "WHERE user_time = #{userTime}")
    List<FinalScoreDto> getFinalScoreData(@Param("userTime") String userTime);

    @Select("SELECT office_name, bonus_points, bonus_reason " +
            "FROM bonus_points_project " +
            "WHERE user_time = #{userTime}")
    List<BonusPointsProjectDto> getBonusPointsProjectData(@Param("userTime") String userTime);



}
