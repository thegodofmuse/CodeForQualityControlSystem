package com.example.qualitycontrolsystem.login.listener.clinic_form_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.UnplannedReoperation;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.UnplannedReoperationService;

import java.util.List;

public class UnplannedReoperationListener implements ReadListener<UnplannedReoperation> {

    private static final int BATCH_COUNT = 100;
    private List<UnplannedReoperation> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private UnplannedReoperation unplannedReoperation;

    private UnplannedReoperationService unplannedReoperationService;

    public UnplannedReoperationListener() {
        unplannedReoperation = new UnplannedReoperation();
    }
    public UnplannedReoperationListener(UnplannedReoperationService unplannedReoperationService) {
        this();
        this.unplannedReoperationService = unplannedReoperationService;
    }

    @Override
    public void invoke(UnplannedReoperation data, AnalysisContext context) {
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
        unplannedReoperationService.saveBatch(cachedDataList);
    }
}

