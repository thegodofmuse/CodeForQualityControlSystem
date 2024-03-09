package com.example.qualitycontrolsystem.login.listener.clinic_form_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.RectificationMeasures;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.RectificationMeasuresService;

import java.util.List;

public class RectificationMeasuresListener implements ReadListener<RectificationMeasures> {

    private static final int BATCH_COUNT = 100;
    private List<RectificationMeasures> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private RectificationMeasures rectificationMeasures;

    private RectificationMeasuresService rectificationMeasuresService;

    public RectificationMeasuresListener() {
        rectificationMeasures = new RectificationMeasures();
    }

    public RectificationMeasuresListener(RectificationMeasuresService rectificationMeasuresService) {
        this();
        this.rectificationMeasuresService = rectificationMeasuresService;
    }

    @Override
    public void invoke(RectificationMeasures data, AnalysisContext context) {
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
        rectificationMeasuresService.saveBatch(cachedDataList);
    }
}
