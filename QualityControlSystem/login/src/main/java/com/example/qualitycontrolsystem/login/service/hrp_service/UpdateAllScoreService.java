package com.example.qualitycontrolsystem.login.service.hrp_service;

import com.example.qualitycontrolsystem.login.dto.hrp_dto.QcFormDto;
import com.example.qualitycontrolsystem.login.mapper.hrp_mapper.UpdateAllScoreMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateAllScoreService {
    private final UpdateAllScoreMapper updateAllScoreMapper;

    public UpdateAllScoreService(UpdateAllScoreMapper updateAllScoreMapper) {
        this.updateAllScoreMapper = updateAllScoreMapper;
    }

    public void updateAllScores(List<QcFormDto> allScoreList) {
        for (QcFormDto allScore : allScoreList) {
            updateAllScoreMapper.updateAllScores(allScore);
        }
    }

}
