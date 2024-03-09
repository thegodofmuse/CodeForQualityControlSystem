package com.example.qualitycontrolsystem.login.service.clinic_form_service;

import com.example.qualitycontrolsystem.login.dto.clinic_form_dto.*;
import com.example.qualitycontrolsystem.login.mapper.clinic_form_mapper.FormClinicDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.reflect.Field; // 用于反射


@Service
public class FormClinicDataService {
    @Autowired
    private FormClinicDataMapper formClinicDataMapper;

    public List<MqManagementTeamOfficeDto> getMQData(String officeName, String userTime) {
        return formClinicDataMapper.getMQData(officeName, userTime);
    }

    public List<ShiftHandoverSystemDto> getShiftHandover(String officeName, String userTime) {
        return formClinicDataMapper.getShiftHandover(officeName, userTime);
    }

    public List<DifficultCaseDiscussionSystemDto> getDifficultCase(String officeName, String userTime) {
        return formClinicDataMapper.getDifficultCase(officeName, userTime);
    }

    public List<DeathCaseDiscussionSystemDto> getDeathCase(String officeName, String userTime) {
        return formClinicDataMapper.getDeathCase(officeName, userTime);
    }

    public List<OutpatientEmergencyAttendanceAssessmentDto1> getOutpatientEmergencyAttendanceAssessmentDto1(String officeName, String userTime) {
        return formClinicDataMapper.getOutpatientEmergencyAttendanceAssessmentDto1(officeName, userTime);
    }

    public List<OutpatientEmergencyAttendanceAssessmentDto2> getOutpatientEmergencyAttendanceAssessmentDto2(String officeName, String userTime) {
        return formClinicDataMapper.getOutpatientEmergencyAttendanceAssessmentDto2(officeName, userTime);
    }

    public List<OutpatientMedicalRecordsDto1> getOutpatientMedicalRecords1(String officeName, String userTime) {
        return formClinicDataMapper.getOutpatientMedicalRecordsDto1(officeName, userTime);
    }
    public List<OutpatientMedicalRecordsDto2> getOutpatientMedicalRecords2(String officeName, String userTime) {
        return formClinicDataMapper.getOutpatientMedicalRecordsDto2(officeName, userTime);
    }

    public List<TimelinessOfWritingDto1> getTimelinessOfWriting1(String officeName, String userTime) {
        return formClinicDataMapper.getTimelinessOfWritingDto1(officeName, userTime);
    }



    public List<SpecialInspectionProjectDto> getSpecialInspectionProject(String officeName, String userTime) {
        return formClinicDataMapper.getSpecialInspectionProjectDto(officeName, userTime);
    }

    public List<FinalMedicalRecordDto> getFinalMedicalRecord(String officeName, String userTime) {
        return formClinicDataMapper.getFinalMedicalRecordDto(officeName, userTime);
    }

    public List<ExtendedHospitalStayManagementDto1> getExtendedHospitalStayManagement1(String officeName, String userTime){
        return formClinicDataMapper.getExtendedHospitalStayManagementDto1(officeName, userTime);
    }

    public List<ExtendedHospitalStayManagementDto2> getExtendedHospitalStayManagement2(String officeName, String userTime){
        return formClinicDataMapper.getExtendedHospitalStayManagementDto2(officeName, userTime);
    }

    private List<ExtendedHospitalStayManagementDto3> getExtendedHospitalStayManagementDto3(String officeName, String userTime) {
        return formClinicDataMapper.getExtendedHospitalStayManagementDto3(officeName, userTime);
    }

    private List<VtePreventionControlIndicatorsDto> getVtePreventionControlIndicatorsDto(String officeName, String userTime) {
        return formClinicDataMapper.getVtePreventionControlIndicatorsDto(officeName, userTime);
    }


    private List<UnplannedReoperationDto2> getUnplannedReoperationDto2(String officeName, String userTime) {
        return formClinicDataMapper.getUnplannedReoperationDto2(officeName, userTime);
    }

    private List<PostoperativeComplicationsDto> getPostoperativeComplicationsDto(String officeName, String userTime) {
        return formClinicDataMapper.getPostoperativeComplicationsDto(officeName, userTime);
    }

    private List<MedicalExamApplicationFormDto> getMedicalExamApplicationFormDto(String officeName, String userTime) {
        return formClinicDataMapper.getMedicalExamApplicationFormDto(officeName, userTime);
    }

    private List<MedicalExamApplicationFormFailDto> getMedicalExamApplicationFormFailDto(String officeName, String userTime) {
        return formClinicDataMapper.getMedicalExamApplicationFormFailDto(officeName, userTime);
    }

    private List<DiameterCalculationDto> getDiameterCalculationDto(String officeName, String userTime) {
        return formClinicDataMapper.getDiameterCalculationDto(officeName,userTime);
    }

//    private List<SingleDiseaseDto1> getSingleDiseaseDto1(String officeName, int year){
//        return formClinicDataMapper.getSingleDiseaseDto1(officeName, year);
//    }

    private List<SingleDiseaseDto2> getSingleDiseaseDto2(String officeName, String userTime){
        return formClinicDataMapper.getSingleDiseaseDto2(officeName, userTime);
    }

    private List<BloodTransfusionRatioDto1> getBloodTransfusionRatioDto1(String officeName, String userTime){
        return formClinicDataMapper.getBloodTransfusionRatioDto1(officeName, userTime);
    }

    private List<BloodTransfusionRatioDto2> getBloodTransfusionRatioDto2(String officeName, String userTime){
        return formClinicDataMapper.getBloodTransfusionRatioDto2(officeName, userTime);
    }

    private List<BloodTransfusionRelatedRecordsDto> getBloodTransfusionRelatedRecordsDto(String officeName, String userTime) {
        return formClinicDataMapper.getBloodTransfusionRelatedRecordsDto(officeName,userTime);
    }

    private List<BloodTransfusionRelatedRecordsDto2> getBloodTransfusionRelatedRecords2(String officeName, String userTime) {
        return formClinicDataMapper.getBloodTransfusionRelatedRecords2(officeName,userTime);
    }

    private List<RationalAdministrationDrugDto> getRationalAdministrationDrugDto(String officeName, String userTime) {
        return formClinicDataMapper.getRationalAdministrationDrugDto(officeName, userTime);
    }

    private List<DoctorPatientRelationshipDto1>getDoctorPatientRelationshipDto1(String officeName, String userTime, String assessmentItems){
        return formClinicDataMapper.getDoctorPatientRelationshipDto1(officeName,userTime,assessmentItems);
    }
    private List<DoctorPatientRelationshipDto2>getDoctorPatientRelationshipDto2(String officeName, String userTime, String assessmentItems){
        return formClinicDataMapper.getDoctorPatientRelationshipDto2(officeName,userTime,assessmentItems);
    }

    private List<DoctorPatientRelationshipDto3>getDoctorPatientRelationshipDto3(String officeName, String userTime, String assessmentItems){
        return formClinicDataMapper.getDoctorPatientRelationshipDto3(officeName,userTime,assessmentItems);
    }

    private List<DoctorPatientRelationshipDto4>getDoctorPatientRelationshipDto4(String officeName, String userTime){
        return formClinicDataMapper.getDoctorPatientRelationshipDto4(officeName,userTime);
    }

    private List<PhPhIdDto> getPhPhIdDto(String officeName, String userTime) {
        return formClinicDataMapper.getPhPhIdDto(officeName,userTime);
    }

    private List<QcRectificationSituationDto> getQcRectificationSituationDto(String officeName, String userTime){
        return formClinicDataMapper.getQcRectificationSituationDto(officeName,userTime);
    }
    private List<RectificationMeasuresDto> getRectificationMeasuresDto(String officeName, String userTime){
        return formClinicDataMapper.getRectificationMeasuresDto(officeName,userTime);
    }
    private List<ObstetricSpecialDto> getObstetricSpecialDto(String officeName, String userTime){
        return formClinicDataMapper.getObstetricSpecialDto(officeName,userTime);
    }




    public ClinicDto getClinicData(String officeName, String userTime) {
        System.out.println("officeName: " + officeName);
        System.out.println("userTime: " + userTime);
        ClinicDto dto = new ClinicDto();

        //科室医疗质量管理
        List<MqManagementTeamOfficeDto> mqData = getMQData(officeName, userTime);

        for (MqManagementTeamOfficeDto mq : mqData) {
            if (mq.getQcDataUploadTime() == null) {
                dto.setMqDataMessage1("未上传");
            } else {
                dto.setMqDataMessage1("已上传");
            }

            if ("是".equals(mq.getUserAdministrativeTools())) {
                dto.setMqDataMessage2("已使用");
            } else {
                dto.setMqDataMessage2("未使用");
            }

            if ("是".equals(mq.getContinuousImprovementEffect())) {
                dto.setMqDataMessage3("已持续改进");
            } else {
                dto.setMqDataMessage3("未持续改进");
            }
        }
        dto.setMqData(mqData);


        //交接班
        List<ShiftHandoverSystemDto> shiftHandoverData = getShiftHandover(officeName, userTime);
        for(ShiftHandoverSystemDto shiftHandover : shiftHandoverData) {
            if ("无".equals(shiftHandover.getEyebrowColumn()) &&
                    "无".equals(shiftHandover.getShiftContent()) &&
                    "无".equals(shiftHandover.getSuccessionContent()) &&
                    "无".equals(shiftHandover.getBedsideHandover()) &&
                    "无".equals(shiftHandover.getShiftDoctorSign()) &&
                    "无".equals(shiftHandover.getSuccessDoctorSign())) {
                shiftHandover.setEyebrowColumn(null);
                shiftHandover.setShiftContent(null);
                shiftHandover.setSuccessionContent(null);
                shiftHandover.setBedsideHandover(null);
                shiftHandover.setShiftDoctorSign(null);
                shiftHandover.setSuccessDoctorSign(null);
            }
        }
        dto.setShiftHandoverData(shiftHandoverData);




        //疑难病例
//        dto.setDifficultCaseData(getDifficultCase(officeName, userTime));
        List<DifficultCaseDiscussionSystemDto>DifficultCaseData = getDifficultCase(officeName, userTime);
        for(DifficultCaseDiscussionSystemDto difficultCase : DifficultCaseData){
            if(difficultCase.getDifficultDiscussion().equals("是")&&
                difficultCase.getParticipation().equals("无欠缺")&&
                difficultCase.getSignedTitle().equals("是")&&
                difficultCase.getParticipationSigned().equals("是")&&
                difficultCase.getSpeechOrder().equals("是")&&
                difficultCase.getPaste().equals("是")&&
                difficultCase.getDiscussionOpinions().equals("是")&&
                difficultCase.getHostSigned().equals("是")&&
                difficultCase.getRecorderSigned().equals("是")&&
                difficultCase.getDeathDiagnosis().equals("是")&&
                difficultCase.getSolution().equals("是")&&
                difficultCase.getScrawledSignature().equals("否")){
            difficultCase.setDifficultDiscussion(null);
            difficultCase.setParticipation(null);
            difficultCase.setSignedTitle(null);
            difficultCase.setParticipationSigned(null);
            difficultCase.setSpeechOrder(null);
            difficultCase.setPaste(null);
            difficultCase.setDiscussionOpinions(null);
            difficultCase.setHostSigned(null);
            difficultCase.setRecorderSigned(null);
            difficultCase.setDeathDiagnosis(null);
            difficultCase.setSolution(null);
            difficultCase.setScrawledSignature(null);

            }
        }
        dto.setDifficultCaseData(DifficultCaseData);

        //死亡病例
        dto.setDeathCaseData(getDeathCase(officeName, userTime));

        //门急诊出勤考核
        List<OutpatientEmergencyAttendanceAssessmentDto1> assessment1 = getOutpatientEmergencyAttendanceAssessmentDto1(officeName, userTime);
        if (assessment1.isEmpty()){
            dto.setOutPatientEmergencyAssessmentMessage("本月无迟到、早退、缺席");
        }else {
            dto.setOutpatientEmergencyAttendanceAssessmentData1(assessment1);
        }
//        dto.setOutpatientEmergencyAttendanceAssessmentData1(getOutpatientEmergencyAttendanceAssessmentDto1(officeName, userTime));
        dto.setOutpatientEmergencyAttendanceAssessmentData2(getOutpatientEmergencyAttendanceAssessmentDto2(officeName, userTime));

        //门诊病历书写
        List<OutpatientMedicalRecordsDto1> outMedicalRecord = getOutpatientMedicalRecords1(officeName, userTime);
        if (outMedicalRecord.isEmpty()){
            dto.setOutPatientMedicalRecordsMessage("本月门诊病历书写质控无缺陷");
        }else {
            dto.setOutpatientMedicalRecordsData1(outMedicalRecord);
        }
//        dto.setOutpatientMedicalRecordsData1(getOutpatientMedicalRecords1(officeName, userTime));
        dto.setOutpatientMedicalRecordsData2(getOutpatientMedicalRecords2(officeName, userTime));

        //书写及时性
//        dto.setTimelinessOfWritingData1(getTimelinessOfWriting1(officeName, userTime));
        List<TimelinessOfWritingDto1> timeliness = getTimelinessOfWriting1(officeName, userTime);
        if (timeliness.isEmpty()) {
            dto.setTimelinessOfWritingMessage("本月运行病历无明显质控缺陷。");
        } else {
            dto.setTimelinessOfWritingData1(timeliness);
        }

            //专项督查项目
        dto.setSpecialInspectionProjectData(getSpecialInspectionProject(officeName, userTime));
        //终末病历
        List<FinalMedicalRecordDto> records = getFinalMedicalRecord(officeName, userTime);
        if (records.isEmpty()) {
            dto.setFinalMedicalRecordDataMessage("本月无乙、丙级病历。");
        } else {
            dto.setFinalMedicalRecordData(records);
        }
        //住院超30天
        List<ExtendedHospitalStayManagementDto1> stayManagement1 = getExtendedHospitalStayManagement1(officeName, userTime);
        if (stayManagement1.isEmpty()) {
            dto.setExtendedHospitalStayManagementDataMessage1("本月无住院超30天病人");
        } else {
            boolean allMatch = true;
            for (ExtendedHospitalStayManagementDto1 management : stayManagement1) {
                if (!"有".equals(management.getStageSummary()) || !"是".equals(management.getDirectorRounds()) || !"是".equals(management.getDiscuss())) {
                    allMatch = false;
                    break;
                }
            }
            if (allMatch) {
                dto.setExtendedHospitalStayManagementDataMessage11("科主任查房、阶段小结、疑难讨论均已书写。");
            } else {
                dto.setExtendedHospitalStayManagementData1(stayManagement1);
            }
        }

        List<ExtendedHospitalStayManagementDto2> stayManagement2 = getExtendedHospitalStayManagement2(officeName, userTime);
        if (stayManagement2.isEmpty()) {
            dto.setExtendedHospitalStayManagementDataMessage2("本月无住院超30天病人");
        } else {
            dto.setExtendedHospitalStayManagementData2(stayManagement2);
        }
        dto.setExtendedHospitalStayManagementData3(getExtendedHospitalStayManagementDto3(officeName, userTime));
        //vte
        dto.setVtePreventionControlIndicatorsData(getVtePreventionControlIndicatorsDto(officeName, userTime));
        //非计划再手术
        UnplannedReoperationDto1 unplannedReoperation = formClinicDataMapper.getUnplannedReoperationDto1(userTime, officeName);
        dto.setUnplannedReoperationData1(unplannedReoperation);

        dto.setUnplannedReoperationData2(getUnplannedReoperationDto2(officeName, userTime));
        //术后并发症
        List<PostoperativeComplicationsDto> complications = getPostoperativeComplicationsDto(officeName, userTime);
        if (complications.isEmpty()) {
            dto.setPostoperativeComplicationsDataMessage("上月无术后并发症。");
        } else {
            dto.setPostoperativeComplicationsData(complications);
        }
        //病检单
        dto.setMedicalExamApplicationFormData(getMedicalExamApplicationFormDto(officeName, userTime));

        List<MedicalExamApplicationFormFailDto> formFail = getMedicalExamApplicationFormFailDto(officeName, userTime);
        if (formFail.isEmpty()) {
            dto.setMedicalExamApplicationFormFailDataMessage("本月病检单质控无明显缺陷。");
        } else {
            for (MedicalExamApplicationFormFailDto formFailDto : formFail) {
                formFailDto.maskPatientName();
            }
            dto.setMedicalExamApplicationFormFailData(formFail);
        }

        //临床路径
        dto.setDiameterCalculationData(getDiameterCalculationDto(officeName, userTime));

        //单病种
        // 提取年份
        int year = Integer.parseInt(userTime.split("-")[0]);
//        dto.setSingleDiseaseData1(getSingleDiseaseDto1(officeName, year));
        dto.setSingleDiseaseData2(getSingleDiseaseDto2(officeName,userTime));
        //输血比例
        dto.setBloodTransfusionRatioData1(getBloodTransfusionRatioDto1(officeName,userTime));
        //用血情况
        List<BloodTransfusionRatioDto2> list = getBloodTransfusionRatioDto2(officeName,userTime);

        for (BloodTransfusionRatioDto2 item : list) {
            Field[] fields = item.getClass().getDeclaredFields();
            for (Field field : fields) {
                try {
                    field.setAccessible(true); // 设置访问权限
                    if (field.get(item) instanceof BigDecimal && ((BigDecimal) field.get(item)).compareTo(BigDecimal.ZERO) == 0) {
                        field.set(item, null);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        List<BloodTransfusionRatioDto2Wrapper> wrappedList = list.stream()
                .map(BloodTransfusionRatioDto2Wrapper::new)
                .collect(Collectors.toList());

        dto.setBloodTransfusionRatioData2(wrappedList);

        //输血相关记录
//        dto.setBloodTransfusionRelatedRecordsData(getBloodTransfusionRelatedRecordsDto(officeName, userTime));
        List<BloodTransfusionRelatedRecordsDto> bloodRecord = getBloodTransfusionRelatedRecordsDto(officeName, userTime);
        if (bloodRecord.isEmpty()) {
            dto.setBloodTransfusionRelatedRecordsData(Collections.emptyList());
            if (dto.getBloodTransfusionRelatedRecordsData().isEmpty()) {
                dto.setBloodTransRecordMessage("本月输血记录无明显质控缺陷");
            }
        } else {
            dto.setBloodTransfusionRelatedRecordsData(bloodRecord);
        }
        dto.setBloodTransfusionRelatedRecordsData2(getBloodTransfusionRelatedRecords2(officeName, userTime));


        //合理用药
        List<RationalAdministrationDrugDto> drug = getRationalAdministrationDrugDto(officeName,userTime);
        if(drug.isEmpty()){
            dto.setRationalAdministrationDrugMessage("本月质控无明显缺陷。");
        }else {
            dto.setRationalAdministrationDrugData(drug);
        }

//        dto.setRationalAdministrationDrugData(getRationalAdministrationDrugDto(officeName,userTime));
        //医患关系
//        String assessmentItems1 = "投诉";
//        String assessmentItems2 = "不良事件";
//
//        dto.setDoctorPatientRelationshipData1(getDoctorPatientRelationshipDto1(officeName, userTime, assessmentItems1));
//        dto.setDoctorPatientRelationshipData2(getDoctorPatientRelationshipDto2(officeName, userTime, assessmentItems2));
        //医患关系
        String assessmentItems1 = "患者权益";
        String assessmentItems2 = "不良事件";
        String assessmentItems3 = "投诉";

        List<DoctorPatientRelationshipDto1> relationship1 = getDoctorPatientRelationshipDto1(officeName, userTime, assessmentItems1);
        if (relationship1.isEmpty()) {
            dto.setDoctorPatientRelationshipMessage1("本月患者权益质控无明显缺陷");
        } else {
            dto.setDoctorPatientRelationshipData1(relationship1);
            dto.setDoctorPatientRelationshipMessage1(null);  // 如果数据不为空，将message设为空
        }

        List<DoctorPatientRelationshipDto2> relationship2 = getDoctorPatientRelationshipDto2(officeName, userTime, assessmentItems2);
        if (relationship2.isEmpty()) {
            dto.setDoctorPatientRelationshipMessage2("本月不良事件质控无明显缺陷");
        } else {
            dto.setDoctorPatientRelationshipData2(relationship2);
            dto.setDoctorPatientRelationshipMessage2(null);  // 如果数据不为空，将message设为空
        }

        List<DoctorPatientRelationshipDto3> relationship3 = getDoctorPatientRelationshipDto3(officeName, userTime, assessmentItems3);
        if (relationship3.isEmpty()) {
            dto.setDoctorPatientRelationshipMessage3("本月无投诉");
        } else {
            dto.setDoctorPatientRelationshipData3(relationship3);
            dto.setDoctorPatientRelationshipMessage3(null);  // 如果数据不为空，将message设为空
        }

        dto.setDoctorPatientRelationshipData4(getDoctorPatientRelationshipDto4(officeName, userTime));


        //公卫、预防保健、传染病
        dto.setPhPhIdData(getPhPhIdDto(officeName,userTime));

        List<PhPhIdDto> phId = getPhPhIdDto(officeName, userTime);
        if (phId.isEmpty()) {
            dto.setPhPhIdMessage1("/");
        } else {
            dto.setPhPhIdData(phId);
        }

        //反馈
        dto.setQcRectificationSituationData(getQcRectificationSituationDto(officeName,userTime));
        dto.setRectificationMeasuresData(getRectificationMeasuresDto(officeName,userTime));

        //产科特别指标
        dto.setObstetricSpecialData(getObstetricSpecialDto(officeName,userTime));



        return dto;

    }

}
