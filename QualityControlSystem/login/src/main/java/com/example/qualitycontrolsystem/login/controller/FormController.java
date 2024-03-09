//质控反馈单接口
package com.example.qualitycontrolsystem.login.controller;

import com.example.qualitycontrolsystem.login.dto.clinic_form_dto.ClinicDto;
import com.example.qualitycontrolsystem.login.dto.clinic_form_dto.FinalAppealDto;
import com.example.qualitycontrolsystem.login.dto.clinic_form_dto.FinalScoreDto;
import com.example.qualitycontrolsystem.login.dto.mt_form_dto.MedicalDto;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.FinalAppealService;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.FinalScoreService;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.FormClinicDataService;
import com.example.qualitycontrolsystem.login.service.mt_form_service.MtFormDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/export/form")
public class FormController {


    @Autowired
    private FormClinicDataService formClinicDataService;

    @PostMapping("/clinic")
    public ClinicDto getClinicData(@RequestParam("officeName") String officeName, @RequestParam("userTime") String userTime) {
        return formClinicDataService.getClinicData(officeName, userTime);
    }

    @Autowired
    private FinalScoreService finalScoreService;
    @GetMapping("/fscore")
    public FinalScoreDto getFinalScore(@RequestParam("officeName") String officeName, @RequestParam("userTime") String userTime){
        return finalScoreService.getFinalScore(officeName, userTime);
    }

    @PostMapping("/fscore")
    public ResponseEntity<String> upsertFinalScore(@RequestParam("officeName") String officeName, @RequestParam("userTime") String userTime, @RequestBody FinalScoreDto finalScoreDto) {
        BigDecimal finalScore = finalScoreDto.getFinalScore(); // 获取前端传递的finalScore值
        finalScoreService.upsertFinalScore(officeName, userTime, finalScore);
        return ResponseEntity.ok("Final score saved successfully");
    }

    @Autowired
    private FinalAppealService finalAppealService;
    @GetMapping("/finalAppeal")
    public FinalAppealDto getFinalAppeal(@RequestParam("officeName") String officeName, @RequestParam("userTime") String userTime){
        return finalAppealService.getFinalAppeal(officeName, userTime);
    }

    @PostMapping("/finalAppeal")
    public ResponseEntity<String> upsertFinalAppeal(@RequestParam("officeName") String officeName, @RequestParam("userTime") String userTime, @RequestBody FinalAppealDto finalAppealDto) {
        String finalAppeal = finalAppealDto.getFinalAppeal(); // 获取前端传递的 finalAppeal 值
        finalAppealService.upsertFinalAppeal(officeName, userTime, finalAppeal);
        return ResponseEntity.ok("Final appeal saved successfully");
    }

    @Autowired
    private MtFormDataService mtFormDataService;
    @PostMapping("/medical")
    public MedicalDto getMedicalData(@RequestParam("officeName") String officeName, @RequestParam("userTime") String userTime) {
        return mtFormDataService.getMedicalData(officeName, userTime);
    }


}


