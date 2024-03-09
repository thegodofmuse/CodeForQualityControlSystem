package com.example.qualitycontrolsystem.login.mapper.clinic_form_mapper;

import com.example.qualitycontrolsystem.login.dto.clinic_form_dto.FinalScoreDto;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;

@Mapper
public interface FinalScoreMapper {
    @Select("SELECT  final_score " +
            "FROM qc_form_feedback_score " +
            "WHERE office_name = #{officeName} AND user_time = #{userTime,jdbcType=DATE}")
    FinalScoreDto getFinalScore(@Param("officeName") String officeName, @Param("userTime") String userTime);
    @Insert("INSERT INTO qc_form_feedback_score (office_name, user_time, final_score) " +
            "VALUES (#{officeName}, #{userTime}, #{finalScore}) " +
            "ON DUPLICATE KEY UPDATE final_score = #{finalScore}")
    void upsertFinalScore(@Param("officeName") String officeName, @Param("userTime") String userTime, @Param("finalScore") BigDecimal finalScore);


}
