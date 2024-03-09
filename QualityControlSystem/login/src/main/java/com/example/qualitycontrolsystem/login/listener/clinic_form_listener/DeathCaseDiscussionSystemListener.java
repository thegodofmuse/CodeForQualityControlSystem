package com.example.qualitycontrolsystem.login.listener.clinic_form_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.DeathCaseDiscussionSystem;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.DeathCaseDiscussionSystemService;


import java.util.List;

public class DeathCaseDiscussionSystemListener implements ReadListener<DeathCaseDiscussionSystem> {

    private static final int BATCH_COUNT = 100;
    private List<DeathCaseDiscussionSystem> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private DeathCaseDiscussionSystem deathCaseDiscussionSystem;

    private DeathCaseDiscussionSystemService deathCaseDiscussionSystemService;

    public DeathCaseDiscussionSystemListener() {
        deathCaseDiscussionSystem = new DeathCaseDiscussionSystem();
    }

    public DeathCaseDiscussionSystemListener(DeathCaseDiscussionSystemService deathCaseDiscussionSystemService) {
        this();
        this.deathCaseDiscussionSystemService = deathCaseDiscussionSystemService;
    }


    @Override
    public void invoke(DeathCaseDiscussionSystem data, AnalysisContext context) {
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
        deathCaseDiscussionSystemService.saveBatch(cachedDataList);
    }

}
