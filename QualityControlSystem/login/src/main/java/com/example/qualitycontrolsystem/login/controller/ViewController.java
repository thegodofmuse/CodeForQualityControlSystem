package com.example.qualitycontrolsystem.login.controller;

import com.example.qualitycontrolsystem.login.dto.view_dto.*;
import com.example.qualitycontrolsystem.login.service.view_service.ViewDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/export/view")
public class ViewController {
    @Autowired
    private ViewDataService viewDataService;

    //vte相关
    @PostMapping("/vte/bleed/month")
    public List<VteBleedMonthDto> getVteMonthData(@RequestParam("userTime") String userTime) {
        return viewDataService.getVteMonthData(userTime);
    }

    @PostMapping("/vte/bleed/season")
    public List<VteBleedSeasonDto> getVteSeasonData(@RequestParam("year") String year, @RequestParam("quarter") String quarter) {
        return viewDataService.getVteSeasonData(year, quarter);
    }

    @PostMapping("/vte/bleed/trend/office")
    public List<VteBleedOfficeTrendDto> getVteOfficeTrendData(@RequestParam("year") String year, @RequestParam("officeName") String officeName){
        return viewDataService. getVteOfficeTrendData(year, officeName);
    }

    @PostMapping("/vte/bleed/trend/hospital/month")
    public List<VteBleedHospitalMonthDto> getVteHospitalMonth(@RequestParam("year") String year){
        return viewDataService.getVteHospitalMonth(year);
    }

    @PostMapping("/vte/bleed/trend/hospital/season")
    public List<VteBleedHospitalSeasonDto> getVteHospitalSeasonData(@RequestParam("year") String year){
        return viewDataService.getVteHospitalSeasonData(year);
    }

    @PostMapping("/vte/pre/month")
    public List<VtePreMonthDto> getVtePreMonthData(@RequestParam("userTime") String userTime) {
        return viewDataService.getVtePreMonthData(userTime);
    }

    @PostMapping("/vte/pre/season")
    public List<VtePreSeasonDto> getVtePreSeasonData(@RequestParam("year") String year, @RequestParam("quarter") String quarter) {
        return viewDataService.getVtePreSeasonData(year, quarter);
    }

    @PostMapping("/vte/pre/trend/office")
    public List<VtePreOfficeTrendDto> getVtePreOfficeTrendData(@RequestParam("year") String year, @RequestParam("officeName") String officeName){
        return viewDataService. getVtePreOfficeTrendData(year, officeName);
    }

    @PostMapping("/vte/pre/trend/hospital/month")
    public List<VtePreHospitalMonthDto> getVtePreHospitalMonthData(@RequestParam("year") String year){
        return viewDataService.getVtePreHospitalMonthData(year);
    }

    @PostMapping("/vte/pre/trend/hospital/season")
    public List<VtePreHospitalSeasonDto> getVtePreHospitalSeasonData(@RequestParam("year") String year){
        return viewDataService.getVtePreHospitalSeasonData(year);
    }
    //非计划再手术相关
    @PostMapping("/unplanned/year/office")
    public List<UnplannedYearOfficeDto> getUnplannedYearOfficeData(@RequestParam("year") String year){
        return viewDataService.getUnplannedYearOfficeData(year);
    }

    @PostMapping("/unplanned/year/compare")
    public List<UnplannedYearOfficeCompareDto> getUnplannedYearOfficeCompareData(@RequestParam("year") int year){
        return viewDataService.getUnplannedYearOfficeCompareData(year);
    }
    //住院超30天相关
    @PostMapping("/extend/hospital")
    public List<ExtendHospitalDto> getExtendHospitalData(@RequestParam("year") String year){
        return viewDataService.getExtendHospitalData(year);
    }
    @PostMapping("/extend/office")
    public List<ExtendOfficeDto> getExtendOfficeData(@RequestParam("year") String year, @RequestParam("officeName") String officeName){
        return viewDataService.getExtendOfficeData(year, officeName);
    }
    @PostMapping("/extend/compare")
    public List<ExtendOfficeCompareDto> getExtendOfficeCompareData(@RequestParam("year") String year, @RequestParam("officeName") String officeName){
        return viewDataService.getExtendOfficeCompareData(year, officeName);
    }
    @PostMapping("/extend/report/season")
    public List<ExtendReportSeasonDto>getExtendReportSeasonData(@RequestParam("year") int year, @RequestParam("quarter") int quarter){
        return viewDataService.getExtendReportSeasonData(year,quarter);
    }
    @PostMapping("/extend/report/half-year")
    public List<ExtendReportHalfDto> getExtendReportHalfData(@RequestParam("year") int year, @RequestParam("halfYear") String halfYear) {
        return viewDataService.getExtendReportHalfData(year, halfYear);
    }
    @PostMapping("/extend/report/year")
    public List<ExtendReportYearDto> getExtendReportYearData(@RequestParam("year") int year) {
        return viewDataService.getExtendReportYearData(year);
    }
    //病案相关
    @PostMapping("medical/record/outDefectPicture")
    public List<OutDefectPictureDto>getOutDefectPictureData(@RequestParam("year") int year){
        return viewDataService.getOutDefectPictureData(year);
    }
    @PostMapping("medical/record/outDefectTable")
    public List<OutDefectTableDto>getOutDefectTableData(@RequestParam("year") int year){
        return viewDataService.getOutDefectTableData(year);
    }
    @PostMapping("medical/record/finalDefectPicture")
    public List<FinalDefectPictureDto>getFinalDefectPictureData(@RequestParam("year") int year){
        return viewDataService.getFinalDefectPictureData(year);
    }
    @PostMapping("medical/record/finalDefectTable")
    public List<FinalDefectTableDto>getFinalDefectTableData(@RequestParam("year") int year){
        return viewDataService.getFinalDefectTableData(year);
    }

}
