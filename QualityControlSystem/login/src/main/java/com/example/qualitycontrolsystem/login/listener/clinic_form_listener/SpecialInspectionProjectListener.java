package com.example.qualitycontrolsystem.login.listener.clinic_form_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.SpecialInspectionProject;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.SpecialInspectionProjectService;

import java.util.List;

public class SpecialInspectionProjectListener implements ReadListener<SpecialInspectionProject> {

    private static final int BATCH_COUNT = 100;
    private List<SpecialInspectionProject> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private SpecialInspectionProject specialInspectionProject;

    private SpecialInspectionProjectService specialInspectionProjectService;

    public SpecialInspectionProjectListener() {
        specialInspectionProject = new SpecialInspectionProject();
    }
    public SpecialInspectionProjectListener(SpecialInspectionProjectService specialInspectionProjectService) {
        this();
        this.specialInspectionProjectService = specialInspectionProjectService;
    }

    @Override
    public void invoke(SpecialInspectionProject data, AnalysisContext context) {
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
        specialInspectionProjectService.saveBatch(cachedDataList);
    }
}
