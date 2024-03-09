package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FinalMedicalRecordDto {



    private String doctorName;
    private String directorName;


    private Long patientId;


    private Long gradeBMedicalRecordDoctorFine;


    private Long gradeBMedicalRecordDirectorFine;



    private Long gradeCMedicalRecordDoctorFine;


    private Long gradeCMedicalRecordDirectorFine;

    private String fineReason;



}

