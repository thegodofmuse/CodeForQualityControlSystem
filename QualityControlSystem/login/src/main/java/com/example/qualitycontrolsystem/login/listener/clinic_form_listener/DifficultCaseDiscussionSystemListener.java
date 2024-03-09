package com.example.qualitycontrolsystem.login.listener.clinic_form_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.DifficultCaseDiscussionSystem;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.DifficultCaseDiscussionSystemService;

import java.util.List;

public class DifficultCaseDiscussionSystemListener implements ReadListener<DifficultCaseDiscussionSystem> {

    private static final int BATCH_COUNT = 100;
    private List<DifficultCaseDiscussionSystem> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private DifficultCaseDiscussionSystem difficultCaseDiscussionSystem;

    private DifficultCaseDiscussionSystemService difficultCaseDiscussionSystemService;

    public DifficultCaseDiscussionSystemListener() {
        difficultCaseDiscussionSystem = new DifficultCaseDiscussionSystem();
    }
    public DifficultCaseDiscussionSystemListener(DifficultCaseDiscussionSystemService difficultCaseDiscussionSystemService) {
        this();
        this.difficultCaseDiscussionSystemService = difficultCaseDiscussionSystemService;
    }

    @Override
    public void invoke(DifficultCaseDiscussionSystem data, AnalysisContext context) {
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
        difficultCaseDiscussionSystemService.saveBatch(cachedDataList);
    }
}