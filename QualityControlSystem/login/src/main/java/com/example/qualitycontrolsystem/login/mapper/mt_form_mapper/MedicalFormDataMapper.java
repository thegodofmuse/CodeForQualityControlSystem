package com.example.qualitycontrolsystem.login.mapper.mt_form_mapper;

import com.example.qualitycontrolsystem.login.dto.mt_form_dto.EmergencyMedicalRecordsDto1;
import com.example.qualitycontrolsystem.login.dto.mt_form_dto.EmergencyMedicalRecordsDto2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MedicalFormDataMapper {
    @Select("SELECT  total_deduction_points, doctor_name, outpatient_number, summary " +
            "FROM emergency_medical_records " +
            "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE} AND records_type = '急诊病历'")
    List<EmergencyMedicalRecordsDto1> getEmergencyMedicalRecordsDto1(@Param("officeName") String officeName, @Param("userTime") String userTime);

    @Select("SELECT  SUM(total_deduction_points) AS total_points_deducted " +
            "FROM emergency_medical_records " +
            "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE} AND records_type = '急诊病历'")
    List<EmergencyMedicalRecordsDto2> getEmergencyMedicalRecordsDto2(@Param("officeName") String officeName, @Param("userTime") String userTime);

    @Select("SELECT  total_deduction_points, doctor_name, outpatient_number, summary " +
            "FROM emergency_medical_records " +
            "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE} AND records_type = '院前急诊抢救病历'")
    List<EmergencyMedicalRecordsDto1> getEmergencyMedicalRecordsDto3(@Param("officeName") String officeName, @Param("userTime") String userTime);

    @Select("SELECT  SUM(total_deduction_points) AS total_points_deducted " +
            "FROM emergency_medical_records " +
            "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE} AND records_type = '院前急诊抢救病历'")
    List<EmergencyMedicalRecordsDto2> getEmergencyMedicalRecordsDto4(@Param("officeName") String officeName, @Param("userTime") String userTime);

    @Select("SELECT  total_deduction_points, doctor_name, outpatient_number, summary " +
            "FROM emergency_medical_records " +
            "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE} AND records_type = '留观病历'")
    List<EmergencyMedicalRecordsDto1> getEmergencyMedicalRecordsDto5(@Param("officeName") String officeName, @Param("userTime") String userTime);

    @Select("SELECT  SUM(total_deduction_points) AS total_points_deducted " +
            "FROM emergency_medical_records " +
            "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE} AND records_type = '留观病历'")
    List<EmergencyMedicalRecordsDto2> getEmergencyMedicalRecordsDto6(@Param("officeName") String officeName, @Param("userTime") String userTime);


}
