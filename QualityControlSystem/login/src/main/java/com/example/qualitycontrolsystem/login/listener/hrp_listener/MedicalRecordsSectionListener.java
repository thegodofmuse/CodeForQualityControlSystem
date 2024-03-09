package com.example.qualitycontrolsystem.login.listener.hrp_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.listener.ReadListener;
import com.example.qualitycontrolsystem.login.entity.hrp_entity.MedicalRecordsSection;
import com.example.qualitycontrolsystem.login.service.hrp_service.MedicalRecordsSectionService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class MedicalRecordsSectionListener extends AnalysisEventListener<MedicalRecordsSection> {
    private static final int BATCH_COUNT = 100;
    private List<MedicalRecordsSection> cachedDataList = new ArrayList<>();
    private final MedicalRecordsSectionService medicalRecordsSectionService;

    public MedicalRecordsSectionListener(MedicalRecordsSectionService medicalRecordsSectionService) {
        this.medicalRecordsSectionService = medicalRecordsSectionService;
    }

    @Override
    public void invoke(MedicalRecordsSection data, AnalysisContext context) {
        cachedDataList.add(data);
        if (cachedDataList.size() >= BATCH_COUNT) {
            saveData();
            cachedDataList.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData();
    }

    private void saveData() {
        medicalRecordsSectionService.saveBatch(cachedDataList);
    }
}
