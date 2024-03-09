package com.example.qualitycontrolsystem.login.service.hrp_service;

import com.example.qualitycontrolsystem.login.dto.hrp_dto.QcFormDto;
import com.example.qualitycontrolsystem.login.entity.hrp_entity.QcFormScore;
import com.example.qualitycontrolsystem.login.mapper.hrp_mapper.QcFormScoreMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QcFormScoreService {
    private final QcFormScoreMapper qcFormScoreMapper;

    public QcFormScoreService(QcFormScoreMapper qcFormScoreMapper) {
        this.qcFormScoreMapper = qcFormScoreMapper;
    }

    public List<QcFormDto> getQcFormScore() {
        List<QcFormScore> qcFormScores = qcFormScoreMapper.getQcFormScore();

        // 将实体类转换为 DTO 类
        List<QcFormDto> qcFormDtos = qcFormScores.stream()
                .map(qcFormScore -> new QcFormDto(qcFormScore.getOfficeName(), qcFormScore.getOfficeScore()))
                .collect(Collectors.toList());

        return qcFormDtos;
    }
}
