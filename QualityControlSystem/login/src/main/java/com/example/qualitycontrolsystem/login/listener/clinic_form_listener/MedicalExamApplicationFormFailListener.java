package com.example.qualitycontrolsystem.login.listener.clinic_form_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.MedicalExamApplicationFormFail;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.MedicalExamApplicationFormFailService;

import java.util.List;

public class MedicalExamApplicationFormFailListener implements ReadListener<MedicalExamApplicationFormFail> {

    private static final int BATCH_COUNT = 100;
    private List<MedicalExamApplicationFormFail> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private MedicalExamApplicationFormFail medicalExamApplicationFormFail;

    private MedicalExamApplicationFormFailService medicalExamApplicationFormFailService;

    public MedicalExamApplicationFormFailListener() {
        medicalExamApplicationFormFail = new MedicalExamApplicationFormFail();
    }
    public MedicalExamApplicationFormFailListener(MedicalExamApplicationFormFailService medicalExamApplicationFormFailService) {
        this();
        this.medicalExamApplicationFormFailService = medicalExamApplicationFormFailService;
    }

    @Override
    public void invoke(MedicalExamApplicationFormFail data, AnalysisContext context) {
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
        medicalExamApplicationFormFailService.saveBatch(cachedDataList);
    }
}
