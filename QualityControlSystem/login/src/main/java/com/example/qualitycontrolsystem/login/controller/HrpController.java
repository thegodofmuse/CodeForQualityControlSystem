package com.example.qualitycontrolsystem.login.controller;

import com.example.qualitycontrolsystem.login.config.message.ResponseObject;
import com.example.qualitycontrolsystem.login.dto.hrp_dto.EmergencyGradesDto;
import com.example.qualitycontrolsystem.login.dto.hrp_dto.GradesFormDto;
import com.example.qualitycontrolsystem.login.dto.hrp_dto.QcFormDto;
import com.example.qualitycontrolsystem.login.service.change_service.ChangeNameService;
import com.example.qualitycontrolsystem.login.service.hrp_service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/hrp")
public class HrpController {
    private final UploadHrpService uploadHrpService;
    private final QcFormScoreService qcFormScoreService;
    private final UpdateAllScoreService updateAllScoreService;


    public HrpController(UploadHrpService uploadHrpService, QcFormScoreService qcFormScoreService, UpdateAllScoreService updateAllScoreService) {
        this.uploadHrpService = uploadHrpService;
        this.qcFormScoreService = qcFormScoreService;
        this.updateAllScoreService = updateAllScoreService;
    }

    @PostMapping("/uploadProjectScore")
    public void excel(MultipartFile file, @RequestParam("flag") int flag) {
        uploadHrpService.excel(file, flag);
    }

    @GetMapping("/qcFormScore")
    public List<QcFormDto> getQcFormScore() {
        return qcFormScoreService.getQcFormScore();
    }

    @PutMapping("/updateQcFormScore")
    public List<QcFormDto> updateAllScore(@RequestBody List<QcFormDto> allScoreList) {
        try {
            // 调用服务类的方法进行数据更新操作
            updateAllScoreService.updateAllScores(allScoreList);
            return qcFormScoreService.getQcFormScore();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Autowired
    private GradesFormService gradesFormService;

    @GetMapping("/query/gradesForm")
    public GradesFormDto getGradesFormData(@RequestParam("userTime") String userTime) {
        return gradesFormService.getGradesFormData(userTime);
    }

    @Autowired
    private EmergencyGradesService emergencyGradesService;

    @GetMapping("/query/emergencyGrades")
    public EmergencyGradesDto getEmergencyGradesData(@RequestParam("userTime") String userTime) {
        return emergencyGradesService.getEmergencyGradesData(userTime);
    }


    @Autowired
    private EncryptExcelService encryptExcelService;

    @PostMapping("/encrypt")
    public ResponseEntity<String> encryptExcelFile(@RequestParam("file") MultipartFile file) {
        try {
            // 创建临时文件
            File tempFile = File.createTempFile("temp", null);
            // 将上传的文件写入临时文件
            file.transferTo(tempFile);
            // 加密临时文件
            encryptExcelService.encryptExcelFile(tempFile.getAbsolutePath());
            // 删除临时文件
            tempFile.delete();
            return new ResponseEntity<>("File successfully encrypted!", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to read file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to encrypt file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}


