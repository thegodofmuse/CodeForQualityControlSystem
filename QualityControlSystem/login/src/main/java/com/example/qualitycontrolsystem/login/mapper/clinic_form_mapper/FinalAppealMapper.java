package com.example.qualitycontrolsystem.login.mapper.clinic_form_mapper;

import com.example.qualitycontrolsystem.login.dto.clinic_form_dto.FinalAppealDto;
import org.apache.ibatis.annotations.*;

@Mapper
public interface FinalAppealMapper {
    @Select("SELECT  final_appeal " +
            "FROM qc_form_final_appeal " +
            "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
    FinalAppealDto getFinalAppeal(@Param("officeName") String officeName, @Param("userTime") String userTime);

    @Insert("INSERT INTO qc_form_final_appeal (office_name, user_time, final_appeal) " +
            "VALUES (#{officeName}, #{userTime}, #{finalAppeal}) " +
            "ON DUPLICATE KEY UPDATE final_appeal = #{finalAppeal}")
    void upsertFinalAppeal(@Param("officeName") String officeName, @Param("userTime") String userTime, @Param("finalAppeal") String finalAppeal);
}
