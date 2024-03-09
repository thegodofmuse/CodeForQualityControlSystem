package com.example.qualitycontrolsystem.login.mapper.view_mapper;

import com.example.qualitycontrolsystem.login.dto.view_dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface ViewExtendMapper {
    //住院超30天相关
    @Select("SELECT MONTH(user_time) AS month, COUNT(*) AS extendNum " +
            "FROM extended_hospital_stay_management " +
            "WHERE YEAR(user_time) = #{year} " +
            "GROUP BY MONTH(user_time)")
    List<ExtendHospitalDto> getExtendHospitalData(@Param("year") String year);

    @Select("SELECT MONTH(user_time) AS month, COUNT(*) AS extendNum " +
            "FROM extended_hospital_stay_management " +
            "WHERE YEAR(user_time) = #{year} AND office_name = #{officeName} " +
            "GROUP BY MONTH(user_time) " +
            "ORDER BY month ASC")
    List<ExtendOfficeDto>getExtendOfficeData(@Param("year") String year, @Param("officeName") String officeName);

    @Select("SELECT " +
            "MONTH(user_time) AS month, " +
            "COUNT(*) AS count, " +
            "CASE " +
            "    WHEN YEAR(user_time) = #{year} - 1 THEN 'Previous Year' " +
            "    ELSE 'Current Year' " +
            "END AS year_type " +
            "FROM extended_hospital_stay_management " +
            "WHERE (YEAR(user_time) = #{year} OR YEAR(user_time) = #{year} - 1 ) AND office_name = #{officeName} " +
            "GROUP BY MONTH(user_time), year_type")
    List<ExtendOfficeCompareDto>getExtendOfficeCompareData(@Param("year") String year, @Param("officeName") String officeName);

    @Select("SELECT office_name, " +
            "SUM(CASE WHEN report_type = '正常上报' THEN 1 ELSE 0 END) AS normal_report_count, " +
            "SUM(CASE WHEN report_type IN ('正常上报', '未上报') THEN 1 ELSE 0 END) AS total_report_count " +
            "FROM extended_hospital_stay_management " +
            "WHERE YEAR(user_time) = #{year} AND QUARTER(user_time) = #{quarter} " +
            "GROUP BY office_name")
    List<ExtendReportSeasonDto> getExtendReportSeasonData(@Param("year") int year, @Param("quarter") int quarter);

    @Select("SELECT office_name, " +
            "SUM(CASE WHEN report_type = '正常上报' THEN 1 ELSE 0 END) AS normal_report_count, " +
            "SUM(CASE WHEN report_type IN ('正常上报', '未上报') THEN 1 ELSE 0 END) AS total_report_count " +
            "FROM extended_hospital_stay_management " +
            "WHERE YEAR(user_time) = #{year} AND MONTH(user_time) BETWEEN #{startMonth} AND #{endMonth} " +
            "GROUP BY office_name")
    List<ExtendReportHalfDto> getExtendReportHalfData(@Param("year") int year, @Param("startMonth") int startMonth, @Param("endMonth") int endMonth);

    @Select("SELECT office_name, " +
            "SUM(CASE WHEN report_type = '正常上报' THEN 1 ELSE 0 END) AS normal_report_count, " +
            "SUM(CASE WHEN report_type IN ('正常上报', '未上报') THEN 1 ELSE 0 END) AS total_report_count " +
            "FROM extended_hospital_stay_management " +
            "WHERE YEAR(user_time) = #{year}  " +
            "GROUP BY office_name")
    List<ExtendReportYearDto> getExtendReportYearData(@Param("year") int year);





}
