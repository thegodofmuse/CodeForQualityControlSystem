package com.example.qualitycontrolsystem.login.listener.hrp_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.listener.ReadListener;
import com.example.qualitycontrolsystem.login.entity.hrp_entity.MedicalServicesSection;
import com.example.qualitycontrolsystem.login.service.hrp_service.MedicalServicesSectionService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MedicalServicesSectionListener extends AnalysisEventListener<MedicalServicesSection> {
    private static final int BATCH_COUNT = 100;
    private List<MedicalServicesSection> cachedDataList = new ArrayList<>();
    private final MedicalServicesSectionService medicalServicesSectionService;

    public MedicalServicesSectionListener(MedicalServicesSectionService medicalServicesSectionService) {
        this.medicalServicesSectionService = medicalServicesSectionService;
    }

    @Override
    public void invoke(MedicalServicesSection data, AnalysisContext context) {
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
        medicalServicesSectionService.saveBatch(cachedDataList);
    }
}
