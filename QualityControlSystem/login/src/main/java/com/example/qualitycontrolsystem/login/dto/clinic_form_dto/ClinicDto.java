package com.example.qualitycontrolsystem.login.dto.clinic_form_dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.List;
@Data
public class ClinicDto {
    private List<MqManagementTeamOfficeDto> mqData;
    private String MqDataMessage1;
    private String MqDataMessage2;
    private String MqDataMessage3;

    private List<ShiftHandoverSystemDto> shiftHandoverData;
    private String eyebrowColumn;
    private String shiftContent;
    private String successionContent;
    private String bedsideHandover;
    private String shiftDoctorSign;
    private String successDoctorSign;


    private List<DifficultCaseDiscussionSystemDto> difficultCaseData;
    private String difficultDiscussion;
    private String medicalRecordType;
    private String participation;
    private String signedTitle;
    private String participationSigned;
    private String speechOrder;
    private String paste;
    private String discussionOpinions;
    private String hostSigned;
    private String recorderSigned;
    private String deathDiagnosis;
    private String solution;
    private String scrawledSignature;




    private List<DeathCaseDiscussionSystemDto> deathCaseData;

    private List<OutpatientEmergencyAttendanceAssessmentDto1> outpatientEmergencyAttendanceAssessmentData1;
    private List<OutpatientEmergencyAttendanceAssessmentDto2> outpatientEmergencyAttendanceAssessmentData2;
    private String OutPatientEmergencyAssessmentMessage;

    private List<OutpatientMedicalRecordsDto1> outpatientMedicalRecordsData1;
    private List<OutpatientMedicalRecordsDto2> outpatientMedicalRecordsData2;
    private String OutPatientMedicalRecordsMessage;

    private List<TimelinessOfWritingDto1> timelinessOfWritingData1;
    private String TimelinessOfWritingMessage;



    private List<SpecialInspectionProjectDto> specialInspectionProjectData;

    private List<FinalMedicalRecordDto> finalMedicalRecordData;
    private String FinalMedicalRecordDataMessage;

    private List<ExtendedHospitalStayManagementDto1>extendedHospitalStayManagementData1;
    private List<ExtendedHospitalStayManagementDto2>extendedHospitalStayManagementData2;
    private List<ExtendedHospitalStayManagementDto3>extendedHospitalStayManagementData3;
    private String ExtendedHospitalStayManagementDataMessage1;
    private String ExtendedHospitalStayManagementDataMessage11;
    private String ExtendedHospitalStayManagementDataMessage2;

    private List<VtePreventionControlIndicatorsDto> vtePreventionControlIndicatorsData;

    private UnplannedReoperationDto1 unplannedReoperationData1;
    private String UnplannedReoperationDataMessage1;
    private List<UnplannedReoperationDto2> unplannedReoperationData2;

    private List<PostoperativeComplicationsDto>postoperativeComplicationsData;
    private String PostoperativeComplicationsDataMessage;

    private List<MedicalExamApplicationFormDto> medicalExamApplicationFormData;

    private List<MedicalExamApplicationFormFailDto>medicalExamApplicationFormFailData;
    private String MedicalExamApplicationFormFailDataMessage;

    private List<DiameterCalculationDto>diameterCalculationData;
    private String DiameterCalculationMessage;

    private List<SingleDiseaseDto1>singleDiseaseData1;
    private List<SingleDiseaseDto2>singleDiseaseData2;

    private List<BloodTransfusionRatioDto1>bloodTransfusionRatioData1;

    private List<BloodTransfusionRatioDto2Wrapper> bloodTransfusionRatioData2;
    public List<BloodTransfusionRatioDto2Wrapper> getBloodTransfusionRatioData2() {
        return bloodTransfusionRatioData2;
    }
    public void setBloodTransfusionRatioData2(List<BloodTransfusionRatioDto2Wrapper> bloodTransfusionRatioData2) {
        this.bloodTransfusionRatioData2 = bloodTransfusionRatioData2;
    }

    private List<BloodTransfusionRelatedRecordsDto>bloodTransfusionRelatedRecordsData;
    private List<BloodTransfusionRelatedRecordsDto2>bloodTransfusionRelatedRecordsData2;
    private String BloodTransRecordMessage;

    private List<RationalAdministrationDrugDto>rationalAdministrationDrugData;
    private String RationalAdministrationDrugMessage;

    private List<DoctorPatientRelationshipDto1>doctorPatientRelationshipData1;
    private List<DoctorPatientRelationshipDto2>doctorPatientRelationshipData2;
    private List<DoctorPatientRelationshipDto3>doctorPatientRelationshipData3;
    private List<DoctorPatientRelationshipDto4>doctorPatientRelationshipData4;
    private  String doctorPatientRelationshipMessage1;
    private  String doctorPatientRelationshipMessage2;
    private  String doctorPatientRelationshipMessage3;

    private List<PhPhIdDto>phPhIdData;
    private String PhPhIdMessage1;

    private List<QcRectificationSituationDto>qcRectificationSituationData;
    private List<RectificationMeasuresDto>rectificationMeasuresData;

    private List<ObstetricSpecialDto>obstetricSpecialData;



}

