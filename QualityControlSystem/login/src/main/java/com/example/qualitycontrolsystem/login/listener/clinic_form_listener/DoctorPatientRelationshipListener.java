package com.example.qualitycontrolsystem.login.listener.clinic_form_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.DoctorPatientRelationship;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.DoctorPatientRelationshipService;

import java.util.List;

public class DoctorPatientRelationshipListener implements ReadListener<DoctorPatientRelationship> {

    private static final int BATCH_COUNT = 100;
    private List<DoctorPatientRelationship> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private DoctorPatientRelationship doctorPatientRelationship;

    private DoctorPatientRelationshipService doctorPatientRelationshipService;

    public DoctorPatientRelationshipListener() {
        doctorPatientRelationship = new DoctorPatientRelationship();
    }
    public DoctorPatientRelationshipListener(DoctorPatientRelationshipService doctorPatientRelationshipService) {
        this();
        this.doctorPatientRelationshipService = doctorPatientRelationshipService;
    }

    @Override
    public void invoke(DoctorPatientRelationship data, AnalysisContext context) {
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
        doctorPatientRelationshipService.saveBatch(cachedDataList);
    }
}
