package com.example.qualitycontrolsystem.login.listener.clinic_form_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.TimelinessOfWriting;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.TimelinessOfWritingService;

import java.util.List;

public class TimelinessOfWritingListener implements ReadListener<TimelinessOfWriting> {

    private static final int BATCH_COUNT = 100;
    private List<TimelinessOfWriting> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private TimelinessOfWriting timelinessOfWriting;

    private TimelinessOfWritingService timelinessOfWritingService;

    public TimelinessOfWritingListener() {
        timelinessOfWriting = new TimelinessOfWriting();
    }
    public TimelinessOfWritingListener(TimelinessOfWritingService timelinessOfWritingService) {
        this();
        this.timelinessOfWritingService = timelinessOfWritingService;
    }

    @Override
    public void invoke(TimelinessOfWriting data, AnalysisContext context) {
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
        timelinessOfWritingService.saveBatch(cachedDataList);
    }
}
