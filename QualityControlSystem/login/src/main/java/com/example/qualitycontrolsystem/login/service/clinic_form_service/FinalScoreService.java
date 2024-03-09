package com.example.qualitycontrolsystem.login.service.clinic_form_service;

import com.example.qualitycontrolsystem.login.dto.clinic_form_dto.FinalScoreDto;
import com.example.qualitycontrolsystem.login.mapper.clinic_form_mapper.FinalScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FinalScoreService {
    @Autowired
    private FinalScoreMapper finalScoreMapper;

    public FinalScoreDto getFinalScore(String officeName, String userTime) {
        return finalScoreMapper.getFinalScore(officeName, userTime);
    }

    public void upsertFinalScore(String officeName, String userTime, BigDecimal finalScore) {
        finalScoreMapper.upsertFinalScore(officeName, userTime, finalScore);
    }

}
