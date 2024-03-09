package com.example.qualitycontrolsystem.login.listener.clinic_form_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.DischargedPatients;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.DischargedPatientsService;

import java.util.List;

public class DischargedPatientsListener implements ReadListener<DischargedPatients> {

    private static final int BATCH_COUNT = 100;
    private List<DischargedPatients> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private DischargedPatients dischargedPatients;

    private DischargedPatientsService dischargedPatientsService;

    public DischargedPatientsListener() {
        dischargedPatients = new DischargedPatients();
    }
    public DischargedPatientsListener(DischargedPatientsService dischargedPatientsService) {
        this();
        this.dischargedPatientsService = dischargedPatientsService;
    }

    @Override
    public void invoke(DischargedPatients data, AnalysisContext context) {
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
        dischargedPatientsService.saveBatch(cachedDataList);
    }
}

