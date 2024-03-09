package com.example.qualitycontrolsystem.login.listener.clinic_form_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.RationalAdministrationDrug;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.RationalAdministrationDrugService;

import java.util.List;

public class RationalAdministrationDrugListener implements ReadListener<RationalAdministrationDrug> {

    private static final int BATCH_COUNT = 100;
    private List<RationalAdministrationDrug> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private RationalAdministrationDrug rationalAdministrationDrug;

    private RationalAdministrationDrugService rationalAdministrationDrugService;

    public RationalAdministrationDrugListener() {
        rationalAdministrationDrug = new RationalAdministrationDrug();
    }
    public RationalAdministrationDrugListener(RationalAdministrationDrugService rationalAdministrationDrugService) {
        this();
        this.rationalAdministrationDrugService = rationalAdministrationDrugService;
    }

    @Override
    public void invoke(RationalAdministrationDrug data, AnalysisContext context) {
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
        rationalAdministrationDrugService.saveBatch(cachedDataList);
    }
}
