package com.example.qualitycontrolsystem.login.listener.clinic_form_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.ShiftHandoverSystem;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.ShiftHandoverSystemService;

import java.util.List;

public class ShiftHandoverSystemListener implements ReadListener<ShiftHandoverSystem> {

    private static final int BATCH_COUNT = 100;
    private List<ShiftHandoverSystem> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private ShiftHandoverSystem shiftHandoverSystem;

    private ShiftHandoverSystemService shiftHandoverSystemService;

    public ShiftHandoverSystemListener() {
        shiftHandoverSystem = new ShiftHandoverSystem();
    }
    public ShiftHandoverSystemListener(ShiftHandoverSystemService shiftHandoverSystemService) {
        this();
        this.shiftHandoverSystemService = shiftHandoverSystemService;
    }

    @Override
    public void invoke(ShiftHandoverSystem data, AnalysisContext context) {
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
        shiftHandoverSystemService.saveBatch(cachedDataList);
    }
}