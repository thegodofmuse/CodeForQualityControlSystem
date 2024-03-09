package com.example.qualitycontrolsystem.login.service.view_service;

import com.example.qualitycontrolsystem.login.dto.view_dto.*;
import com.example.qualitycontrolsystem.login.mapper.view_mapper.ViewExtendMapper;
import com.example.qualitycontrolsystem.login.mapper.view_mapper.ViewMedicalRecordMapper;
import com.example.qualitycontrolsystem.login.mapper.view_mapper.ViewUnplannedMapper;
import com.example.qualitycontrolsystem.login.mapper.view_mapper.ViewVteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ViewDataService {
    @Autowired
    private ViewVteMapper viewVteMapper;
    //vte相关
    public List<VteBleedMonthDto> getVteMonthData(String userTime) {
        return viewVteMapper.getVteMonthData(userTime);
    }

public List<VteBleedSeasonDto> getVteSeasonData(String year, String quarter) {
    List<VteBleedSeasonDto> result = new ArrayList<>();

    List<VteBleedSeasonDto> queryResult = viewVteMapper.getVteSeasonData(year, quarter);

    // 使用一个 Map 来按照办公室名称分组
    Map<String, List<VteBleedSeasonDto>> officeMap = new HashMap<>();
    for (VteBleedSeasonDto data : queryResult) {
        String officeName = data.getOfficeName();
        officeMap.putIfAbsent(officeName, new ArrayList<>());
        officeMap.get(officeName).add(data);
    }

    // 对每个办公室的数据按照月份排序，并构建 VteSeasonDto 对象
    for (Map.Entry<String, List<VteBleedSeasonDto>> entry : officeMap.entrySet()) {
        String officeName = entry.getKey();
        List<VteBleedSeasonDto> officeData = entry.getValue();

        // 按照月份排序
        officeData.sort(Comparator.comparingInt(VteBleedSeasonDto::getMonth));

        // 构建 VteSeasonDto 对象
        VteBleedSeasonDto dto = new VteBleedSeasonDto();
        dto.setOfficeName(officeName);

        List<Double> rateArray = new ArrayList<>();
        for (VteBleedSeasonDto data : officeData) {
            rateArray.add(data.getVteBleedingRiskAssessmentRate().doubleValue());
        }
        dto.setVteBleedingRiskAssessmentRateArray(rateArray);

        result.add(dto);
    }

    return result;
}

    public List<VteBleedOfficeTrendDto> getVteOfficeTrendData(String year, String officeName){
        return viewVteMapper.getVteOfficeTrendData(year,officeName);
    }

    public List<VteBleedHospitalMonthDto>getVteHospitalMonth(String year){
        return viewVteMapper.getVteHospitalMonth(year);
    }

    public List<VteBleedHospitalSeasonDto>getVteHospitalSeasonData(String year){
        return viewVteMapper.getVteHospitalSeasonData(year);
    }

    public List<VtePreMonthDto>getVtePreMonthData(String userTime){
        return viewVteMapper.getVtePreMonthData(userTime);
    }

    public List<VtePreSeasonDto> getVtePreSeasonData(String year, String quarter) {
        List<VtePreSeasonDto> result = new ArrayList<>();

        List<VtePreSeasonDto> queryResult = viewVteMapper.getVtePreSeasonData(year, quarter);

        // 使用一个 Map 来按照办公室名称分组
        Map<String, List<VtePreSeasonDto>> officeMap = new HashMap<>();
        for (VtePreSeasonDto data : queryResult) {
            String officeName = data.getOfficeName();
            officeMap.putIfAbsent(officeName, new ArrayList<>());
            officeMap.get(officeName).add(data);
        }

        // 对每个办公室的数据按照月份排序，并构建 VteSeasonDto 对象
        for (Map.Entry<String, List<VtePreSeasonDto>> entry : officeMap.entrySet()) {
            String officeName = entry.getKey();
            List<VtePreSeasonDto> officeData = entry.getValue();

            // 按照月份排序
            officeData.sort(Comparator.comparingInt(VtePreSeasonDto::getMonth));

            // 构建  对象
            VtePreSeasonDto dto = new VtePreSeasonDto();
            dto.setOfficeName(officeName);

            List<Double> rateArray = new ArrayList<>();
            for (VtePreSeasonDto data : officeData) {
                rateArray.add(data.getVtePreventionRate().doubleValue());
            }
            dto.setVtePreventionRateArray(rateArray);

            result.add(dto);
        }

        return result;
    }

    public List<VtePreOfficeTrendDto> getVtePreOfficeTrendData(String year, String officeName){
        return viewVteMapper.getVtePreOfficeTrendData(year,officeName);
    }

    public List<VtePreHospitalMonthDto>getVtePreHospitalMonthData(String year){
        return viewVteMapper.getVtePreHospitalMonthData(year);
    }

    public List<VtePreHospitalSeasonDto>getVtePreHospitalSeasonData(String year){
        return viewVteMapper.getVtePreHospitalSeasonData(year);
    }
    //非计划再手术相关
    @Autowired
    private ViewUnplannedMapper viewUnplannedMapper;
    public List<UnplannedYearOfficeDto>getUnplannedYearOfficeData(String year){
        return viewUnplannedMapper.getUnplannedYearOfficeData(year);
    }

    public List<UnplannedYearOfficeCompareDto> getUnplannedYearOfficeCompareData(int year) {
        List<UnplannedYearOfficeCompareDto> result = viewUnplannedMapper.getUnplannedYearOfficeCompareData(year);
        for (UnplannedYearOfficeCompareDto unplannedYearOfficeCompareDto : result) {
            unplannedYearOfficeCompareDto.setCountArray(List.of(unplannedYearOfficeCompareDto.getCountPrevYear(), unplannedYearOfficeCompareDto.getCountYear()));
        }
        return result;
    }
    //住院超30天相关
    @Autowired
    private ViewExtendMapper viewExtendMapper;
    public List<ExtendHospitalDto>getExtendHospitalData(String year){
        return viewExtendMapper.getExtendHospitalData(year);
    }
    public List<ExtendOfficeDto>getExtendOfficeData(String year, String officeName){
        return viewExtendMapper.getExtendOfficeData(year, officeName);
    }

    public List<ExtendOfficeCompareDto> getExtendOfficeCompareData(String year, String officeName) {
        // 假设这是你的Mapper方法，它返回一个结果列表
        List<ExtendOfficeCompareDto> results = viewExtendMapper.getExtendOfficeCompareData(year, officeName);

        // 使用HashMap来存储每个月的计数值
        // 使用HashMap来存储每个月的计数值
        Map<Integer, List<Double>> monthCounts = new HashMap<>();

// 遍历结果列表
        for (ExtendOfficeCompareDto result : results) {
            // 获取当前结果的月份和计数值
            int month = result.getMonth();
            double count = result.getCount();
            String yearType = result.getYearType();

            // 如果HashMap中还没有这个月份的数据，就创建一个新的计数列表
            if (!monthCounts.containsKey(month)) {
                monthCounts.put(month, new ArrayList<>(Arrays.asList(0.0, 0.0)));
            }

            // 根据年份类型将计数值添加到正确的位置
            if (yearType.equals("Previous Year")) {
                monthCounts.get(month).set(0, count);
            } else if (yearType.equals("Current Year")) {
                monthCounts.get(month).set(1, count);
            }
        }

// 用于存储最终结果的列表
        List<ExtendOfficeCompareDto> finalResults = new ArrayList<>();

// 遍历HashMap的每个月份，创建一个新的ExtendOfficeCompareDto对象，并将其添加到最终结果列表中
        for (Map.Entry<Integer, List<Double>> entry : monthCounts.entrySet()) {
            ExtendOfficeCompareDto dto = new ExtendOfficeCompareDto();
            dto.setMonth(entry.getKey());
            dto.setCountList(entry.getValue());
            finalResults.add(dto);
        }

        return finalResults;

    }

    public List<ExtendReportSeasonDto>getExtendReportSeasonData(int year, int quarter){
        return viewExtendMapper.getExtendReportSeasonData(year,quarter);
    }

    public List<ExtendReportHalfDto> getExtendReportHalfData(int year, String halfYear) {
        int startMonth;
        int endMonth;

        if (halfYear.equals("上半年")) {
            startMonth = 1;
            endMonth = 6;
        } else if (halfYear.equals("下半年")) {
            startMonth = 7;
            endMonth = 12;
        } else {
            // 处理异常情况，如输入的 halfYear 值不是上半年或下半年
            return null;  // 或者抛出异常
        }

        return viewExtendMapper.getExtendReportHalfData(year, startMonth, endMonth);
    }

    public List<ExtendReportYearDto>getExtendReportYearData(int year){
        return viewExtendMapper.getExtendReportYearData(year);
    }

    //病案缺陷相关
    @Autowired
    private ViewMedicalRecordMapper viewMedicalRecordMapper;
    public List<OutDefectPictureDto>getOutDefectPictureData(int year){
        return viewMedicalRecordMapper.getOutDefectPictureData(year);
    }
    public List<OutDefectTableDto>getOutDefectTableData(int year){
        return viewMedicalRecordMapper.getOutDefectTableData(year);
    }

    public List<FinalDefectPictureDto>getFinalDefectPictureData(int year){
        return viewMedicalRecordMapper.getFinalDefectPictureData(year);
    }
    public List<FinalDefectTableDto>getFinalDefectTableData(int year){
        return viewMedicalRecordMapper.getFinalDefectTableData(year);
    }




}
