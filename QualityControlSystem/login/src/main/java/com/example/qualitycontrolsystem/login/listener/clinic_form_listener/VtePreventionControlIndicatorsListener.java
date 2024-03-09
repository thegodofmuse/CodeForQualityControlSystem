package com.example.qualitycontrolsystem.login.listener.clinic_form_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.VtePreventionControlIndicators;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.VtePreventionControlIndicatorsService;

import java.util.List;

public class VtePreventionControlIndicatorsListener implements ReadListener<VtePreventionControlIndicators> {

    private static final int BATCH_COUNT = 100;
    private List<VtePreventionControlIndicators> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private VtePreventionControlIndicators vtePreventionControlIndicators;

    private VtePreventionControlIndicatorsService vtePreventionControlIndicatorsService;

    public VtePreventionControlIndicatorsListener() {
        vtePreventionControlIndicators = new VtePreventionControlIndicators();
    }
    public VtePreventionControlIndicatorsListener(VtePreventionControlIndicatorsService vtePreventionControlIndicatorsService) {
        this();
        this.vtePreventionControlIndicatorsService = vtePreventionControlIndicatorsService;
    }

    @Override
    public void invoke(VtePreventionControlIndicators data, AnalysisContext context) {
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
        vtePreventionControlIndicatorsService.saveBatch(cachedDataList);
    }
}
