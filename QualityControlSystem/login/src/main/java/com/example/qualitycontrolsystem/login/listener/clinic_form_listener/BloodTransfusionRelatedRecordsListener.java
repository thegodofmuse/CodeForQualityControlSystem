package com.example.qualitycontrolsystem.login.listener.clinic_form_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.BloodTransfusionRelatedRecords;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.BloodTransfusionRelatedRecordsService;

import java.util.List;

public class BloodTransfusionRelatedRecordsListener implements ReadListener<BloodTransfusionRelatedRecords> {

    private static final int BATCH_COUNT = 100;
    private List<BloodTransfusionRelatedRecords> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private BloodTransfusionRelatedRecords bloodTransfusionRelatedRecords;

    private BloodTransfusionRelatedRecordsService bloodTransfusionRelatedRecordsService;

    public BloodTransfusionRelatedRecordsListener() {
        bloodTransfusionRelatedRecords = new BloodTransfusionRelatedRecords();
    }
    public BloodTransfusionRelatedRecordsListener(BloodTransfusionRelatedRecordsService bloodTransfusionRelatedRecordsService) {
        this();
        this.bloodTransfusionRelatedRecordsService = bloodTransfusionRelatedRecordsService;
    }

    @Override
    public void invoke(BloodTransfusionRelatedRecords data, AnalysisContext context) {
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
        bloodTransfusionRelatedRecordsService.saveBatch(cachedDataList);
    }
}

