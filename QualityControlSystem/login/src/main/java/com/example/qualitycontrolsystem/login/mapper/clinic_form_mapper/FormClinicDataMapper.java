package com.example.qualitycontrolsystem.login.mapper.clinic_form_mapper;

import com.example.qualitycontrolsystem.login.dto.clinic_form_dto.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FormClinicDataMapper {
        @Select("SELECT  points_deducted, qc_data_upload_time, user_administrative_tools, continuous_improvement_effect " +
                "FROM mq_management_team_office " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<MqManagementTeamOfficeDto> getMQData(@Param("officeName") String officeName, @Param("userTime") String userTime);


        @Select("SELECT points_deducted, eyebrow_column,shift_content, succession_content,bedside_handover, shift_doctor_sign, success_doctor_sign  " +
                "FROM shift_handover_system " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<ShiftHandoverSystemDto> getShiftHandover(@Param("officeName") String officeName, @Param("userTime") String userTime);

        @Select("SELECT points_deducted, difficult_discussion, unplanned_reoperation, postoperative_com, medical_record_type, participation, signed_title, participation_signed, " +
                "speech_order, paste, discussion_opinions, host_signed, recorder_signed, death_diagnosis, solution, scrawled_signature " +
                "FROM difficult_case_discussion_system " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<DifficultCaseDiscussionSystemDto> getDifficultCase(@Param("officeName") String officeName, @Param("userTime") String userTime);

        @Select("SELECT  points_deducted, has_case_death, has_record, participation, signed_title, participation_signed, speech_order, paste, discussion_opinions, host_signed, recorder_signed, death_diagnosis, sum_experience, scrawled_signature " +
                "FROM death_case_discussion_system " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<DeathCaseDiscussionSystemDto> getDeathCase(@Param("officeName") String officeName, @Param("userTime") String userTime);

        @Select("SELECT   doctor_name, outpatient_emergency_attendance " +
                "FROM outpatient_emergency_attendance_assessment " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<OutpatientEmergencyAttendanceAssessmentDto1> getOutpatientEmergencyAttendanceAssessmentDto1(@Param("officeName") String officeName, @Param("userTime") String userTime);

        @Select("SELECT SUM(points_deducted) AS total_points_deducted " +
                "FROM outpatient_emergency_attendance_assessment " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime, jdbcType=DATE}")
        List<OutpatientEmergencyAttendanceAssessmentDto2> getOutpatientEmergencyAttendanceAssessmentDto2(@Param("officeName") String officeName, @Param("userTime") String userTime);


        @Select("SELECT  total_deduction_points, doctor_name, outpatient_number, summary " +
                "FROM outpatient_medical_records " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<OutpatientMedicalRecordsDto1> getOutpatientMedicalRecordsDto1(@Param("officeName") String officeName, @Param("userTime") String userTime);

        @Select("SELECT  SUM(total_deduction_points) AS total_points_deducted " +
                "FROM outpatient_medical_records " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<OutpatientMedicalRecordsDto2> getOutpatientMedicalRecordsDto2(@Param("officeName") String officeName, @Param("userTime") String userTime);

        @Select("SELECT admission_number, doctor_name, project_name, qc_result " +
                "FROM timeliness_of_writing " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<TimelinessOfWritingDto1> getTimelinessOfWritingDto1(@Param("officeName") String officeName, @Param("userTime") String userTime);


        @Select("SELECT doctor_name, admission_number, key_inspections_this_month, rectification_status_issues_last_month " +
                "FROM special_inspection_project " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<SpecialInspectionProjectDto> getSpecialInspectionProjectDto(@Param("officeName") String officeName, @Param("userTime") String userTime);

        @Select("SELECT doctor_name, patient_id, director_name, fine_reason, " +
                "CASE WHEN grade_b_medical_record = '有' THEN grade_b_medical_record_doctor_fine ELSE NULL END AS gradeBMedicalRecordDoctorFine, " +
                "CASE WHEN grade_b_medical_record = '有' THEN grade_b_medical_record_director_fine ELSE NULL END AS gradeBMedicalRecordDirectorFine, " +
                "CASE WHEN grade_c_medical_record = '有' THEN grade_c_medical_record_doctor_fine ELSE NULL END AS gradeCMedicalRecordDoctorFine, " +
                "CASE WHEN grade_c_medical_record = '有' THEN grade_c_medical_record_director_fine ELSE NULL END AS gradeCMedicalRecordDirectorFine " +
                "FROM final_medical_record " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime}")
        List<FinalMedicalRecordDto> getFinalMedicalRecordDto(@Param("officeName") String officeName, @Param("userTime") String userTime);


        @Select("SELECT  admission_number,stage_summary,office_discuss, director_rounds, discuss " +
                "FROM extended_hospital_stay_management " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<ExtendedHospitalStayManagementDto1> getExtendedHospitalStayManagementDto1(@Param("officeName") String officeName, @Param("userTime") String userTime);

        @Select("SELECT points_deducted, admission_number, doctor_name, report_type " +
                "FROM extended_hospital_stay_management " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<ExtendedHospitalStayManagementDto2> getExtendedHospitalStayManagementDto2(@Param("officeName") String officeName, @Param("userTime") String userTime);

        @Select("SELECT  SUM(points_deducted) AS total_points_deducted " +
                "FROM extended_hospital_stay_management " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<ExtendedHospitalStayManagementDto3> getExtendedHospitalStayManagementDto3(@Param("officeName") String officeName, @Param("userTime") String userTime);

        @Select("SELECT points_deducted, vte_bleeding_risk_assessment_rate, vte_prevention_rate " +
                "FROM vte_prevention_control_indicators " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<VtePreventionControlIndicatorsDto> getVtePreventionControlIndicatorsDto(@Param("officeName") String officeName, @Param("userTime") String userTime);


        @Select("SELECT COUNT(*) AS total_count, IFNULL(SUM(points_deducted), 0) AS deducted_total " +
                "FROM unplanned_reoperation " +
                "WHERE user_time = #{userTime} AND office_name = #{officeName}")
        UnplannedReoperationDto1 getUnplannedReoperationDto1(@Param("userTime") String userTime, @Param("officeName") String officeName);

        @Select("SELECT admission_number, report_type, director_rounds, discuss " +
                "FROM unplanned_reoperation " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<UnplannedReoperationDto2> getUnplannedReoperationDto2(@Param("officeName") String officeName, @Param("userTime") String userTime);

        @Select("SELECT admission_number " +
                "FROM postoperative_complications " +
                "WHERE discharge_office = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<PostoperativeComplicationsDto> getPostoperativeComplicationsDto(@Param("officeName") String officeName, @Param("userTime") String userTime);

        @Select("SELECT points_deducted, unqualified_cases_number, failure_rate " +
                "FROM medical_exam_application_form " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<MedicalExamApplicationFormDto> getMedicalExamApplicationFormDto(@Param("officeName") String officeName, @Param("userTime") String userTime);

        @Select("SELECT patient_name, doctor_name, reception_time, application_form_specification, doctor_advice, specimen_fixation_time, add_sample_fixation_solution " +
                "FROM medical_exam_application_form_fail " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<MedicalExamApplicationFormFailDto> getMedicalExamApplicationFormFailDto(@Param("officeName") String officeName, @Param("userTime") String userTime);

        @Select("SELECT points_deducted, completion_rate, enrollment_rate, entry_rate " +
                "FROM diameter_calculation " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<DiameterCalculationDto> getDiameterCalculationDto(@Param("officeName") String officeName, @Param("userTime") String userTime);

//        @Select("SELECT AVG(filling_rate) AS average_filling_rate " +
//                "FROM single_disease " +
//                "WHERE office_name = #{officeName} AND YEAR(user_time) = #{year}")
//        List<SingleDiseaseDto1> getSingleDiseaseDto1(@Param("officeName") String officeName, @Param("year") int year);

        @Select("SELECT reporting_rate, points_deducted " +
                "FROM single_disease " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<SingleDiseaseDto2> getSingleDiseaseDto2(@Param("officeName") String officeName, @Param("userTime") String userTime);

        @Select("SELECT component_blood_ratio " +
                "FROM blood_transfusion_ratio " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<BloodTransfusionRatioDto1> getBloodTransfusionRatioDto1(@Param("officeName") String officeName, @Param("userTime") String userTime);

        @Select("SELECT " + "a_type_suspension_red, a_type_plasma, b_type_suspension_red, b_type_plasma, o_type_suspension_red, " +
                "o_type_plasma, ab_type_suspension_red, ab_type_plasma, wash_rbc, thaw_rbc, full_blood, apheresis_platelets, cryoprecipitate " +
                "FROM blood_transfusion_ratio " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime}")
        List<BloodTransfusionRatioDto2> getBloodTransfusionRatioDto2(@Param("officeName") String officeName, @Param("userTime") String userTime);

        @Select("SELECT points_deducted, admission_number, zhuguan_doctor_name, major_defect " +
                "FROM blood_transfusion_related_records " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<BloodTransfusionRelatedRecordsDto> getBloodTransfusionRelatedRecordsDto(@Param("officeName") String officeName, @Param("userTime") String userTime);

        @Select("SELECT  SUM(points_deducted) AS total_points_deducted " +
                "FROM blood_transfusion_related_records " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<BloodTransfusionRelatedRecordsDto2>getBloodTransfusionRelatedRecords2(@Param("officeName") String officeName, @Param("userTime") String userTime);
        @Select("SELECT person_responsible, admission_outpatient_num, quality_control_details, assessment_results, appeal " +
                "FROM rational_administration_drug " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<RationalAdministrationDrugDto> getRationalAdministrationDrugDto(@Param("officeName") String officeName, @Param("userTime") String userTime);

        @Select("SELECT assessee, patient_name_num, quality_control_details, assessment_results " +
                "FROM doctor_patient_relationship " +
                "WHERE user_time = #{userTime} AND office_name = #{officeName} AND assessment_items = '患者权益'")
        List<DoctorPatientRelationshipDto1> getDoctorPatientRelationshipDto1(@Param("officeName") String officeName, @Param("userTime") String userTime, @Param("assessmentItems") String assessmentItems);

        @Select("SELECT assessee, patient_name_num, quality_control_details, assessment_results " +
                "FROM doctor_patient_relationship " +
                "WHERE user_time = #{userTime} AND office_name = #{officeName} AND assessment_items = '不良事件'")
        List<DoctorPatientRelationshipDto2> getDoctorPatientRelationshipDto2(@Param("officeName") String officeName, @Param("userTime") String userTime, @Param("assessmentItems") String assessmentItems);

        @Select("SELECT assessee, patient_name_num, quality_control_details, assessment_results " +
                "FROM doctor_patient_relationship " +
                "WHERE user_time = #{userTime} AND office_name = #{officeName} AND assessment_items = '投诉'")
        List<DoctorPatientRelationshipDto3> getDoctorPatientRelationshipDto3(@Param("officeName") String officeName, @Param("userTime") String userTime, @Param("assessmentItems") String assessmentItems);

        @Select("SELECT SUM(points_deducted) AS total_points_deducted " +
                "FROM doctor_patient_relationship " +
                "WHERE user_time = #{userTime} AND office_name = #{officeName}")
        List<DoctorPatientRelationshipDto4> getDoctorPatientRelationshipDto4(@Param("officeName") String officeName, @Param("userTime") String userTime);

        @Select("SELECT ward_health_education, death_monitoring_work, vaccines_and_cold_chain, foodborne_disease_monitoring, infectious_disease_reporting, maternal_child_work, public_health_check " +
                "FROM ph_ph_id " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<PhPhIdDto> getPhPhIdDto(@Param("officeName") String officeName, @Param("userTime") String userTime);

        @Select("SELECT rectification_situation " +
                "FROM qc_rectification_situation " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<QcRectificationSituationDto> getQcRectificationSituationDto(@Param("officeName") String officeName, @Param("userTime") String userTime);

        @Select("SELECT measure " +
                "FROM rectification_measures " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<RectificationMeasuresDto> getRectificationMeasuresDto(@Param("officeName") String officeName, @Param("userTime") String userTime);

        @Select("SELECT exclusive_breastfeeding, abnormal_cesarean, cesarean, complications_of_vaginal_delivery " +
                "FROM obstetric_special " +
                "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
        List<ObstetricSpecialDto> getObstetricSpecialDto(@Param("officeName") String officeName, @Param("userTime") String userTime);



}

