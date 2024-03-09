package com.example.qualitycontrolsystem.login.mapper.hrp_mapper;

import com.example.qualitycontrolsystem.login.entity.hrp_entity.QcFormScore;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QcFormScoreMapper {
    @Select("SELECT * FROM qc_form_score")
    List<QcFormScore> getQcFormScore();
}
