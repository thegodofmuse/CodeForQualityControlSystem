package com.example.qualitycontrolsystem.login.listener.clinic_form_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.QcRectificationSituation;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.QcRectificationSituationService;

import java.util.List;

public class QcRectificationSituationListener implements ReadListener<QcRectificationSituation> {

    private static final int BATCH_COUNT = 100;
    private List<QcRectificationSituation> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private QcRectificationSituation qcRectificationSituation;

    private QcRectificationSituationService qcRectificationSituationService;

    public QcRectificationSituationListener() {
        qcRectificationSituation = new QcRectificationSituation();
    }

    public QcRectificationSituationListener(QcRectificationSituationService qcRectificationSituationService) {
        this();
        this.qcRectificationSituationService = qcRectificationSituationService;
    }

    @Override
    public void invoke(QcRectificationSituation data, AnalysisContext context) {
        cachedDataList.add(data);
        if (cachedDataList.size() >= BATCH_COUNT) {
            saveData();
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData();
    }

    private void saveData() {
        qcRectificationSituationService.saveBatch(cachedDataList);
    }
}

