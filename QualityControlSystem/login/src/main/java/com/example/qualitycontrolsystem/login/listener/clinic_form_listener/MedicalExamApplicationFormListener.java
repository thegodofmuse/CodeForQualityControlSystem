package com.example.qualitycontrolsystem.login.listener.clinic_form_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.MedicalExamApplicationForm;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.MedicalExamApplicationFormService;

import java.util.List;

public class MedicalExamApplicationFormListener implements ReadListener<MedicalExamApplicationForm> {

    private static final int BATCH_COUNT = 100;
    private List<MedicalExamApplicationForm> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private MedicalExamApplicationForm medicalExamApplicationForm;

    private MedicalExamApplicationFormService medicalExamApplicationFormService;

    public MedicalExamApplicationFormListener() {
        medicalExamApplicationForm = new MedicalExamApplicationForm();
    }
    public MedicalExamApplicationFormListener(MedicalExamApplicationFormService medicalExamApplicationFormService) {
        this();
        this.medicalExamApplicationFormService = medicalExamApplicationFormService;
    }

    @Override
    public void invoke(MedicalExamApplicationForm data, AnalysisContext context) {
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
        medicalExamApplicationFormService.saveBatch(cachedDataList);
    }
}
