package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;
import lombok.Data;

@Data
public class OutpatientMedicalRecordsDto1 {



    private String doctorName;
    private String outpatientNumber;

    private String summary;
    private Double totalDeductionPoints;

}
