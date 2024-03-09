package com.example.qualitycontrolsystem.login.service.clinic_form_service;

import com.example.qualitycontrolsystem.login.dto.clinic_form_dto.FinalAppealDto;
import com.example.qualitycontrolsystem.login.mapper.clinic_form_mapper.FinalAppealMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinalAppealService {
    @Autowired
    private FinalAppealMapper finalAppealMapper;

    public FinalAppealDto getFinalAppeal(String officeName, String userTime) {
        return finalAppealMapper.getFinalAppeal(officeName, userTime);
    }

    public void upsertFinalAppeal(String officeName, String userTime, String finalAppeal) {
        finalAppealMapper.upsertFinalAppeal(officeName, userTime, finalAppeal);
    }
}
