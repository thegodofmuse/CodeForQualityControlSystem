package com.example.qualitycontrolsystem.login.listener.clinic_form_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.BloodTransfusionRatio;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.BloodTransfusionRatioService;

import java.util.List;

public class BloodTransfusionRatioListener implements ReadListener<BloodTransfusionRatio> {

    private static final int BATCH_COUNT = 100;
    private List<BloodTransfusionRatio> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private BloodTransfusionRatio bloodTransfusionRatio;

    private BloodTransfusionRatioService bloodTransfusionRatioService;

    public BloodTransfusionRatioListener() {
        bloodTransfusionRatio = new BloodTransfusionRatio();
    }
    public BloodTransfusionRatioListener(BloodTransfusionRatioService bloodTransfusionRatioService) {
        this();
        this.bloodTransfusionRatioService = bloodTransfusionRatioService;
    }

    @Override
    public void invoke(BloodTransfusionRatio data, AnalysisContext context) {
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
        bloodTransfusionRatioService.saveBatch(cachedDataList);
    }
}
