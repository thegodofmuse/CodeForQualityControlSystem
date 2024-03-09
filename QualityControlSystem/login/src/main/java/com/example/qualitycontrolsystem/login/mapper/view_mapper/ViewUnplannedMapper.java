package com.example.qualitycontrolsystem.login.mapper.view_mapper;

import com.example.qualitycontrolsystem.login.dto.view_dto.UnplannedYearOfficeCompareDto;
import com.example.qualitycontrolsystem.login.dto.view_dto.UnplannedYearOfficeDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface ViewUnplannedMapper {
    //非计划再手术相关
    @Select("SELECT office_name, COUNT(*) AS count " +
            "FROM unplanned_reoperation " +
            "WHERE YEAR(user_time) = #{year} " +
            "GROUP BY office_name")
    List<UnplannedYearOfficeDto> getUnplannedYearOfficeData(@Param("year") String year);

    @Select("SELECT ur.office_name, COUNT(ur_prev.user_time) AS count_prev_year, COUNT(ur.user_time) AS count_year " +
            "FROM unplanned_reoperation ur " +
            "LEFT JOIN ( " +
            "    SELECT office_name, user_time " +
            "    FROM unplanned_reoperation " +
            "    WHERE YEAR(user_time) = #{year} - 1 " +
            ") ur_prev ON ur.office_name = ur_prev.office_name " +
            "WHERE YEAR(ur.user_time) = #{year} " +
            "GROUP BY ur.office_name")
    List<UnplannedYearOfficeCompareDto> getUnplannedYearOfficeCompareData(@Param("year") int year);
}
