package com.example.qualitycontrolsystem.login.service.clinic_form_service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;


public interface UploadClinicService {
    void excel(MultipartFile file, int flag);
}
