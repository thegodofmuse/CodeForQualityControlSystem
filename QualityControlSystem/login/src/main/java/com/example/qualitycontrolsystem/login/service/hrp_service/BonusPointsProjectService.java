package com.example.qualitycontrolsystem.login.service.hrp_service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.qualitycontrolsystem.login.entity.hrp_entity.BonusPointsProject;
import com.example.qualitycontrolsystem.login.entity.hrp_entity.MedicalRecordsSection;
import com.example.qualitycontrolsystem.login.mapper.hrp_mapper.BonusPointsProjectMapper;
import com.example.qualitycontrolsystem.login.mapper.hrp_mapper.MedicalRecordsSectionMapper;
import org.springframework.stereotype.Service;

@Service
public class BonusPointsProjectService extends ServiceImpl<BonusPointsProjectMapper, BonusPointsProject> {
}
