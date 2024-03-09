package com.example.qualitycontrolsystem.login.controller;

import com.example.qualitycontrolsystem.login.config.message.ResponseObject;
import com.example.qualitycontrolsystem.login.service.change_service.ChangeEncodingService;
import com.example.qualitycontrolsystem.login.service.change_service.ChangeExcelLayoutService;
import com.example.qualitycontrolsystem.login.service.change_service.ChangeNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/change")
public class ChangeController {
    @Autowired
    private ChangeNameService changeNameService;

    @PostMapping("/name")
    public ResponseObject changeName(@RequestParam("file") MultipartFile file) {
        System.out.println("Handling /api/change/name request...");  // 添加日志输出
        return changeNameService.changeName(file);
    }

    @Autowired
    private ChangeEncodingService changeEncodingService;
    @PostMapping("/encoding")
    public ResponseObject changeEncoding(@RequestParam("file") MultipartFile file) {
        return changeEncodingService.changeEncoding(file);
    }

    @Autowired
    private ChangeExcelLayoutService changeExcelLayoutService;
    @PostMapping("/layout")
    public ResponseObject changeExcelLayout(@RequestParam("file") MultipartFile file) {
        return changeExcelLayoutService.changeExcelLayout(file);
    }


}


