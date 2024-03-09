package com.example.qualitycontrolsystem.login.listener.clinic_form_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.ExtendedHospitalStayManagement;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.ExtendedHospitalStayManagementService;

import java.util.List;

public class ExtendedHospitalStayManagementListener implements ReadListener<ExtendedHospitalStayManagement> {

    private static final int BATCH_COUNT = 100;
    private List<ExtendedHospitalStayManagement> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private ExtendedHospitalStayManagement extendedHospitalStayManagement;

    private ExtendedHospitalStayManagementService extendedHospitalStayManagementService;

    public ExtendedHospitalStayManagementListener() {
        extendedHospitalStayManagement = new ExtendedHospitalStayManagement();
    }
    public ExtendedHospitalStayManagementListener(ExtendedHospitalStayManagementService extendedHospitalStayManagementService) {
        this();
        this.extendedHospitalStayManagementService = extendedHospitalStayManagementService;
    }

    @Override
    public void invoke(ExtendedHospitalStayManagement data, AnalysisContext context) {
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
        extendedHospitalStayManagementService.saveBatch(cachedDataList);
    }
}
