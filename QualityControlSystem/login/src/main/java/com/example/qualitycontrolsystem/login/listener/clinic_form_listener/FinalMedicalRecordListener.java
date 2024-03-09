package com.example.qualitycontrolsystem.login.listener.clinic_form_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.FinalMedicalRecord;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.FinalMedicalRecordService;

import java.util.List;

public class FinalMedicalRecordListener implements ReadListener<FinalMedicalRecord> {

    private static final int BATCH_COUNT = 100;
    private List<FinalMedicalRecord> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private FinalMedicalRecord finalMedicalRecord;

    private FinalMedicalRecordService finalMedicalRecordService;

    public FinalMedicalRecordListener() {
        finalMedicalRecord = new FinalMedicalRecord();
    }
    public FinalMedicalRecordListener(FinalMedicalRecordService finalMedicalRecordService) {
        this();
        this.finalMedicalRecordService = finalMedicalRecordService;
    }

    @Override
    public void invoke(FinalMedicalRecord data, AnalysisContext context) {
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
        finalMedicalRecordService.saveBatch(cachedDataList);
    }
}

