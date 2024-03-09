package com.example.qualitycontrolsystem.login.listener.clinic_form_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.ClinicalPathway;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.ClinicalPathwayService;

import java.util.List;

public class ClinicalPathwayListener implements ReadListener<ClinicalPathway> {

    private static final int BATCH_COUNT = 100;
    private List<ClinicalPathway> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private ClinicalPathway clinicalPathway;

    private ClinicalPathwayService clinicalPathwayService;

    public ClinicalPathwayListener() {
        clinicalPathway = new ClinicalPathway();
    }
    public ClinicalPathwayListener(ClinicalPathwayService clinicalPathwayService) {
        this();
        this.clinicalPathwayService = clinicalPathwayService;
    }

    @Override
    public void invoke(ClinicalPathway data, AnalysisContext context) {
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
        clinicalPathwayService.saveBatch(cachedDataList);
    }
}

