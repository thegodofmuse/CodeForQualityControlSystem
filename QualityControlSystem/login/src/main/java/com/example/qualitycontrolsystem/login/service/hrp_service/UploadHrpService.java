package com.example.qualitycontrolsystem.login.service.hrp_service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.StringUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.*;
import com.example.qualitycontrolsystem.login.entity.hrp_entity.BonusPointsProject;
import com.example.qualitycontrolsystem.login.entity.hrp_entity.MedicalRecordsSection;
//import com.example.qualitycontrolsystem.login.entity.hrp_entity.MedicalServicesSection;
import com.example.qualitycontrolsystem.login.listener.clinic_form_listener.*;
import com.example.qualitycontrolsystem.login.listener.hrp_listener.BonusPointsProjectListener;
import com.example.qualitycontrolsystem.login.listener.hrp_listener.MedicalRecordsSectionListener;
//import com.example.qualitycontrolsystem.login.listener.hrp_listener.MedicalServicesSectionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Objects;

@Service
public class UploadHrpService {
//    @Autowired
//    private MedicalServicesSectionService medicalServicesSectionService;

    @Autowired
    private MedicalRecordsSectionService medicalRecordsSectionService;

    @Autowired
    private BonusPointsProjectService bonusPointsProjectService;


    public void excel(MultipartFile file, int flag) {
        File f = convert(file);
        if (Objects.isNull(f)) {
            return;
        }
        String fileName = f.getAbsolutePath();
        switch (flag) {
            case 1:
//                EasyExcel.read(
//                        fileName,
//                        MedicalServicesSection.class,
//                        new MedicalServicesSectionListener(medicalServicesSectionService)
//                ).sheet().doRead();
                break;
            case 2:
                EasyExcel.read(
                        fileName,
                        MedicalRecordsSection.class,
                        new MedicalRecordsSectionListener(medicalRecordsSectionService)
                ).sheet().doRead();
                break;
            case 3:
                EasyExcel.read(
                        fileName,
                        BonusPointsProject.class,
                        new BonusPointsProjectListener(bonusPointsProjectService)
                ).sheet().doRead();
                break;
            default:
                break;
        }
        f.delete();
    }


    private File convert(MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        if (StringUtils.isEmpty(fileName)) {
            return null;
        }
        File file = new File(fileName);
        OutputStream out = null;
        try {
            out = Files.newOutputStream(file.toPath());
            byte[] ss = multipartFile.getBytes();
            for (int i = 0; i < ss.length; i++) {
                out.write(ss[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }
}
