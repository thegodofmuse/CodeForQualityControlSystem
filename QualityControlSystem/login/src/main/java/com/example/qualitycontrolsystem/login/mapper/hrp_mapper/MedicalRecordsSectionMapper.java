package com.example.qualitycontrolsystem.login.mapper.hrp_mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.qualitycontrolsystem.login.entity.hrp_entity.MedicalRecordsSection;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MedicalRecordsSectionMapper extends BaseMapper<MedicalRecordsSection> {
    //不知道哪里出问题了，无法正确插入数据，只能自己重写了一个插入方法
    @Insert("INSERT INTO medical_records_section SET office_name=#{officeName}, medical_record_page_score=#{medicalRecordPageScore}, user_time=#{userTime}")
    int insert(MedicalRecordsSection entity);
}
