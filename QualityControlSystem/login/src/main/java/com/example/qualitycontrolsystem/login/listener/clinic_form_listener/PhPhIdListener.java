package com.example.qualitycontrolsystem.login.listener.clinic_form_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.PhPhId;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.PhPhIdService;

import java.util.List;

public class PhPhIdListener implements ReadListener<PhPhId> {

    private static final int BATCH_COUNT = 100;
    private List<PhPhId> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private PhPhId phPhId;

    private PhPhIdService phPhIdService;

    public PhPhIdListener() {
        phPhId = new PhPhId();
    }
    public PhPhIdListener(PhPhIdService phPhIdService) {
        this();
        this.phPhIdService = phPhIdService;
    }

    @Override
    public void invoke(PhPhId data, AnalysisContext context) {
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
        phPhIdService.saveBatch(cachedDataList);
    }
}

