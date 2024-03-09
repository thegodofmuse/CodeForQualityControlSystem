package com.example.qualitycontrolsystem.login.service.mt_form_service;

import com.example.qualitycontrolsystem.login.dto.mt_form_dto.EmergencyMedicalRecordsDto1;
import com.example.qualitycontrolsystem.login.dto.mt_form_dto.EmergencyMedicalRecordsDto2;
import com.example.qualitycontrolsystem.login.dto.mt_form_dto.MedicalDto;
import com.example.qualitycontrolsystem.login.mapper.mt_form_mapper.MedicalFormDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MtFormDataService {

    @Autowired
    private MedicalFormDataMapper medicalFormDataMapper;

    private List<EmergencyMedicalRecordsDto1> getEmergencyMedicalRecordsDto1(String officeName, String userTime){
        return medicalFormDataMapper.getEmergencyMedicalRecordsDto1(officeName, userTime);
    }

    private List<EmergencyMedicalRecordsDto2> getEmergencyMedicalRecordsDto2(String officeName, String userTime){
        return medicalFormDataMapper.getEmergencyMedicalRecordsDto2(officeName, userTime);
    }
    private List<EmergencyMedicalRecordsDto1> getEmergencyMedicalRecordsDto3(String officeName, String userTime){
        return medicalFormDataMapper.getEmergencyMedicalRecordsDto3(officeName, userTime);
    }
    private List<EmergencyMedicalRecordsDto2> getEmergencyMedicalRecordsDto4(String officeName, String userTime){
        return medicalFormDataMapper.getEmergencyMedicalRecordsDto4(officeName, userTime);
    }
    private List<EmergencyMedicalRecordsDto1> getEmergencyMedicalRecordsDto5(String officeName, String userTime){
        return medicalFormDataMapper.getEmergencyMedicalRecordsDto5(officeName, userTime);
    }
    private List<EmergencyMedicalRecordsDto2> getEmergencyMedicalRecordsDto6(String officeName, String userTime){
        return medicalFormDataMapper.getEmergencyMedicalRecordsDto6(officeName, userTime);
    }

    public MedicalDto getMedicalData(String officeName, String userTime) {
        System.out.println("officeName: " + officeName);
        System.out.println("userTime: " + userTime);
        MedicalDto mdto = new MedicalDto();

        mdto.setEmergencyMedicalRecordsData1(getEmergencyMedicalRecordsDto1(officeName, userTime));
        mdto.setEmergencyMedicalRecordsData2(getEmergencyMedicalRecordsDto2(officeName, userTime));
        mdto.setEmergencyMedicalRecordsData3(getEmergencyMedicalRecordsDto3(officeName, userTime));
        mdto.setEmergencyMedicalRecordsData4(getEmergencyMedicalRecordsDto4(officeName, userTime));
        mdto.setEmergencyMedicalRecordsData5(getEmergencyMedicalRecordsDto5(officeName, userTime));
        mdto.setEmergencyMedicalRecordsData6(getEmergencyMedicalRecordsDto6(officeName, userTime));

        return mdto;

    }

}
