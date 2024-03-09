package com.example.qualitycontrolsystem.login.listener.hrp_listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.qualitycontrolsystem.login.entity.hrp_entity.BonusPointsProject;
import com.example.qualitycontrolsystem.login.entity.hrp_entity.MedicalRecordsSection;
import com.example.qualitycontrolsystem.login.service.hrp_service.BonusPointsProjectService;
import com.example.qualitycontrolsystem.login.service.hrp_service.MedicalRecordsSectionService;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class BonusPointsProjectListener extends AnalysisEventListener<BonusPointsProject> {
    private static final int BATCH_COUNT = 100;
    private List<BonusPointsProject> cachedDataList = new ArrayList<>();
    private final BonusPointsProjectService bonusPointsProjectService;

    public BonusPointsProjectListener(BonusPointsProjectService bonusPointsProjectService) {
        this.bonusPointsProjectService = bonusPointsProjectService;
    }

    @Override
    public void invoke(BonusPointsProject data, AnalysisContext context) {
        cachedDataList.add(data);
        if (cachedDataList.size() >= BATCH_COUNT) {
            saveData();
            cachedDataList.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData();
    }

    private void saveData() {
        bonusPointsProjectService.saveBatch(cachedDataList);
    }
}
