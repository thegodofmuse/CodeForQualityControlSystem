package com.example.qualitycontrolsystem.login.mapper.hrp_mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.qualitycontrolsystem.login.dto.hrp_dto.QcFormDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UpdateAllScoreMapper extends BaseMapper<QcFormDto> {
    @Update("UPDATE qc_form_score SET office_score = #{officeScore} WHERE office_name = #{officeName}")
    void updateAllScores(QcFormDto allScore);
}
