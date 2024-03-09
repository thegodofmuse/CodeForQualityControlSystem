package com.example.qualitycontrolsystem.login.listener.clinic_form_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.PostoperativeComplications;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.PostoperativeComplicationsService;

import java.util.List;

public class PostoperativeComplicationsListener implements ReadListener<PostoperativeComplications> {

    private static final int BATCH_COUNT = 100;
    private List<PostoperativeComplications> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private PostoperativeComplications postoperativeComplications;

    private PostoperativeComplicationsService postoperativeComplicationsService;

    public PostoperativeComplicationsListener() {
        postoperativeComplications = new PostoperativeComplications();
    }
    public PostoperativeComplicationsListener(PostoperativeComplicationsService postoperativeComplicationsService) {
        this();
        this.postoperativeComplicationsService = postoperativeComplicationsService;
    }

    @Override
    public void invoke(PostoperativeComplications data, AnalysisContext context) {
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
        postoperativeComplicationsService.saveBatch(cachedDataList);
    }
}
