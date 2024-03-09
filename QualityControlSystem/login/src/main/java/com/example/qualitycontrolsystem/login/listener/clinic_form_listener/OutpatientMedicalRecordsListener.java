package com.example.qualitycontrolsystem.login.listener.clinic_form_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.OutpatientMedicalRecords;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.OutpatientMedicalRecordsService;

import java.util.List;

public class OutpatientMedicalRecordsListener implements ReadListener<OutpatientMedicalRecords> {

    private static final int BATCH_COUNT = 100;
    private List<OutpatientMedicalRecords> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private OutpatientMedicalRecords outpatientMedicalRecords;

    private OutpatientMedicalRecordsService outpatientMedicalRecordsService;

    public OutpatientMedicalRecordsListener() {
        outpatientMedicalRecords = new OutpatientMedicalRecords();
    }
    public OutpatientMedicalRecordsListener(OutpatientMedicalRecordsService outpatientMedicalRecordsService) {
        this();
        this.outpatientMedicalRecordsService = outpatientMedicalRecordsService;
    }

    @Override
    public void invoke(OutpatientMedicalRecords data, AnalysisContext context) {
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
        outpatientMedicalRecordsService.saveBatch(cachedDataList);
    }
}

