package com.example.qualitycontrolsystem.login.service.clinic_form_service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.BloodTransfusionRatio;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.ObstetricSpecial;
import com.example.qualitycontrolsystem.login.mapper.clinic_form_mapper.BloodTransfusionRatioMapper;
import com.example.qualitycontrolsystem.login.mapper.clinic_form_mapper.ObstetricSpecialMapper;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.BloodTransfusionRatioService;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.ObstetricSpecialService;
import org.springframework.stereotype.Service;

@Service
public class ObstetricSpecialImpl extends ServiceImpl<ObstetricSpecialMapper, ObstetricSpecial> implements ObstetricSpecialService {
}
