package com.example.qualitycontrolsystem.login.listener.clinic_form_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.SingleDisease;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.SingleDiseaseService;

import java.util.List;

public class SingleDiseaseListener implements ReadListener<SingleDisease> {

    private static final int BATCH_COUNT = 100;
    private List<SingleDisease> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private SingleDisease singleDisease;

    private SingleDiseaseService singleDiseaseService;

    public SingleDiseaseListener() {
        singleDisease = new SingleDisease();
    }
    public SingleDiseaseListener(SingleDiseaseService singleDiseaseService) {
        this();
        this.singleDiseaseService = singleDiseaseService;
    }

    @Override
    public void invoke(SingleDisease data, AnalysisContext context) {
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
        singleDiseaseService.saveBatch(cachedDataList);
    }
}

