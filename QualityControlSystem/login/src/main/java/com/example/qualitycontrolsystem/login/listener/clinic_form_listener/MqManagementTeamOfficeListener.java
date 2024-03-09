package com.example.qualitycontrolsystem.login.listener.clinic_form_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.MqManagementTeamOffice;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.MqManagementTeamOfficeService;

import java.util.List;

public class MqManagementTeamOfficeListener implements ReadListener<MqManagementTeamOffice> {

    private static final int BATCH_COUNT = 100;
    private List<MqManagementTeamOffice> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private MqManagementTeamOffice mqManagementTeamOffice;

    private MqManagementTeamOfficeService mqManagementTeamOfficeService;

    public MqManagementTeamOfficeListener() {
        mqManagementTeamOffice = new MqManagementTeamOffice();
    }
    public MqManagementTeamOfficeListener(MqManagementTeamOfficeService mqManagementTeamOfficeService) {
        this();
        this.mqManagementTeamOfficeService = mqManagementTeamOfficeService;
    }

    @Override
    public void invoke(MqManagementTeamOffice data, AnalysisContext context) {
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
        mqManagementTeamOfficeService.saveBatch(cachedDataList);
    }
}