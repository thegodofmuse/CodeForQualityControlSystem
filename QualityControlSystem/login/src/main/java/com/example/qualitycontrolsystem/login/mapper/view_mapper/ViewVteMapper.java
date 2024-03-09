package com.example.qualitycontrolsystem.login.mapper.view_mapper;

import com.example.qualitycontrolsystem.login.dto.view_dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ViewVteMapper {
    //vte相关
    @Select("SELECT vte_bleeding_risk_assessment_rate, office_name " +
            "FROM vte_prevention_control_indicators " +
            "WHERE user_time = #{userTime,jdbcType=DATE} " +
            "ORDER BY vte_bleeding_risk_assessment_rate ASC")
    List<VteBleedMonthDto> getVteMonthData(@Param("userTime") String userTime);

    @Select("SELECT vte_bleeding_risk_assessment_rate, office_name, MONTH(user_time) AS month " +
            "FROM vte_prevention_control_indicators " +
            "WHERE YEAR(user_time) = #{year} AND QUARTER(user_time) = #{quarter}")
    List<VteBleedSeasonDto> getVteSeasonData(@Param("year") String year, @Param("quarter") String quarter);

    @Select("SELECT vte_bleeding_risk_assessment_rate, MONTH(user_time) AS month " +
            "FROM vte_prevention_control_indicators " +
            "WHERE YEAR(user_time) = #{year} AND office_name = #{officeName}")
    List<VteBleedOfficeTrendDto> getVteOfficeTrendData(@Param("year") String year, @Param("officeName") String officeName);

    @Select("SELECT MONTH(user_time) AS month, ROUND(AVG(vte_bleeding_risk_assessment_rate), 2) AS average_rate " +
            "FROM vte_prevention_control_indicators " +
            "WHERE YEAR(user_time) = #{year} " +
            "GROUP BY MONTH(user_time)")
    List<VteBleedHospitalMonthDto> getVteHospitalMonth (@Param("year") String year);

    @Select("SELECT QUARTER(user_time) AS quarter, ROUND(AVG(vte_bleeding_risk_assessment_rate), 2) AS average_rate " +
            "FROM vte_prevention_control_indicators " +
            "WHERE YEAR(user_time) = #{year} " +
            "GROUP BY QUARTER(user_time)")
    List<VteBleedHospitalSeasonDto> getVteHospitalSeasonData(@Param("year") String year);

    @Select("SELECT vte_prevention_rate, office_name " +
            "FROM vte_prevention_control_indicators " +
            "WHERE user_time = #{userTime,jdbcType=DATE} " +
            "ORDER BY vte_prevention_rate ASC")
    List<VtePreMonthDto> getVtePreMonthData(@Param("userTime") String userTime);

    @Select("SELECT vte_prevention_rate, office_name, MONTH(user_time) AS month " +
            "FROM vte_prevention_control_indicators " +
            "WHERE YEAR(user_time) = #{year} AND QUARTER(user_time) = #{quarter}")
    List<VtePreSeasonDto> getVtePreSeasonData(@Param("year") String year, @Param("quarter") String quarter);

    @Select("SELECT vte_prevention_rate, MONTH(user_time) AS month " +
            "FROM vte_prevention_control_indicators " +
            "WHERE YEAR(user_time) = #{year} AND office_name = #{officeName}")
    List<VtePreOfficeTrendDto> getVtePreOfficeTrendData(@Param("year") String year, @Param("officeName") String officeName);

    @Select("SELECT MONTH(user_time) AS month, ROUND(AVG(vte_prevention_rate), 2) AS average_rate " +
            "FROM vte_prevention_control_indicators " +
            "WHERE YEAR(user_time) = #{year} " +
            "GROUP BY MONTH(user_time)")
    List<VtePreHospitalMonthDto> getVtePreHospitalMonthData (@Param("year") String year);

    @Select("SELECT QUARTER(user_time) AS quarter, ROUND(AVG(vte_prevention_rate), 2) AS average_rate " +
            "FROM vte_prevention_control_indicators " +
            "WHERE YEAR(user_time) = #{year} " +
            "GROUP BY QUARTER(user_time)")
    List<VtePreHospitalSeasonDto> getVtePreHospitalSeasonData(@Param("year") String year);






}

