package com.example.qualitycontrolsystem.login.mapper.view_mapper;

import com.example.qualitycontrolsystem.login.dto.view_dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ViewMedicalRecordMapper {
    @Select("SELECT doctor_name, SUM(total_deduction_points) AS point " +
            "FROM outpatient_medical_records " +
            "WHERE YEAR(user_time) = #{year} " +
            "GROUP BY doctor_name")
    List<OutDefectPictureDto> getOutDefectPictureData(@Param("year") int year);

    @Select("SELECT doctor_name, SUM(total_deduction_points) AS point " +
            "FROM outpatient_medical_records " +
            "WHERE YEAR(user_time) = #{year} " +
            "GROUP BY doctor_name " +  // Added space here
            "ORDER BY point DESC " +   // Added space here
            "LIMIT 50")                 // Added the LIMIT clause
    List<OutDefectTableDto> getOutDefectTableData(@Param("year") int year);

    @Select("SELECT doctor_name, SUM(COALESCE(grade_b_medical_record_doctor_fine, 0) + COALESCE(grade_c_medical_record_doctor_fine, 0)) AS fine " +
            "FROM final_medical_record " +
            "WHERE YEAR(user_time) = #{year} " +
            "GROUP BY doctor_name")
    List<FinalDefectPictureDto> getFinalDefectPictureData(@Param("year") int year);

    @Select("SELECT doctor_name, SUM(COALESCE(grade_b_medical_record_doctor_fine, 0) + COALESCE(grade_c_medical_record_doctor_fine, 0)) AS fine " +
            "FROM final_medical_record " +
            "WHERE YEAR(user_time) = #{year} " +
            "GROUP BY doctor_name " +  // Added space here
            "ORDER BY fine DESC " +   // Added space here
            "LIMIT 50")                 // Added the LIMIT clause
    List<FinalDefectTableDto> getFinalDefectTableData(@Param("year") int year);

}
