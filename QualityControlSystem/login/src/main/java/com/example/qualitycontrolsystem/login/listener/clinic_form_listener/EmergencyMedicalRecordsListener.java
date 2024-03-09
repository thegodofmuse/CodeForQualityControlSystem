package com.example.qualitycontrolsystem.login.listener.clinic_form_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.EmergencyMedicalRecords;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.EmergencyMedicalRecordsService;

import java.util.List;

public class EmergencyMedicalRecordsListener implements ReadListener<EmergencyMedicalRecords> {

    private static final int BATCH_COUNT = 100;
    private List<EmergencyMedicalRecords> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private EmergencyMedicalRecords emergencyMedicalRecords;

    private EmergencyMedicalRecordsService emergencyMedicalRecordsService;

    public EmergencyMedicalRecordsListener() {
        emergencyMedicalRecords = new EmergencyMedicalRecords();
    }
    public EmergencyMedicalRecordsListener(EmergencyMedicalRecordsService emergencyMedicalRecordsService) {
        this();
        this.emergencyMedicalRecordsService = emergencyMedicalRecordsService;
    }

    @Override
    public void invoke(EmergencyMedicalRecords data, AnalysisContext context) {
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
        emergencyMedicalRecordsService.saveBatch(cachedDataList);
    }
}

