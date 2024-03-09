package com.example.qualitycontrolsystem.login.service.clinic_form_service.impl;


import com.alibaba.excel.EasyExcel;
        import com.alibaba.excel.util.StringUtils;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.*;
import com.example.qualitycontrolsystem.login.listener.clinic_form_listener.*;
import com.example.qualitycontrolsystem.login.listener.clinic_form_listener.MqManagementTeamOfficeListener;
        import com.example.qualitycontrolsystem.login.listener.clinic_form_listener.ShiftHandoverSystemListener;
import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.MqManagementTeamOffice;
        import com.example.qualitycontrolsystem.login.entity.clinic_form_entity.ShiftHandoverSystem;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.UploadClinicService;
import com.example.qualitycontrolsystem.login.service.clinic_form_service.*;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.web.multipart.MultipartFile;

        import java.io.File;
import java.io.IOException;
        import java.io.OutputStream;
        import java.nio.file.Files;
        import java.util.Objects;


@Service
public class UploadClinicServiceImpl implements UploadClinicService {
    @Autowired
    private MqManagementTeamOfficeService mqManagementTeamOfficeService;

    @Autowired
    private ShiftHandoverSystemService shiftHandoverSystemService;

    @Autowired
    private DifficultCaseDiscussionSystemService difficultCaseDiscussionSystemService;

    @Autowired
    private DeathCaseDiscussionSystemService deathCaseDiscussionSystemService;

    @Autowired
    private BloodTransfusionRatioService bloodTransfusionRatioService;

    @Autowired
    private BloodTransfusionRelatedRecordsService bloodTransfusionRelatedRecordsService;

    @Autowired
    private ClinicalPathwayService clinicalPathwayService;

    @Autowired
    private DischargedPatientsService dischargedPatientsService;

    @Autowired
    private DoctorPatientRelationshipService doctorPatientRelationshipService;

    @Autowired
    private EmergencyMedicalRecordsService emergencyMedicalRecordsService;

    @Autowired
    private ExtendedHospitalStayManagementService extendedHospitalStayManagementService;

    @Autowired
    private FinalMedicalRecordService finalMedicalRecordService;

    @Autowired
    private MedicalExamApplicationFormService medicalExamApplicationFormService;

    @Autowired
    private MedicalExamApplicationFormFailService medicalExamApplicationFormFailService;

    @Autowired
    private OutpatientEmergencyAttendanceAssessmentService outpatientEmergencyAttendanceAssessmentService;

    @Autowired
    private OutpatientMedicalRecordsService outpatientMedicalRecordsService;

    @Autowired
    private PhPhIdService phPhIdService;

    @Autowired
    private PostoperativeComplicationsService postoperativeComplicationsService;

    @Autowired
    private RationalAdministrationDrugService rationalAdministrationDrugService;

    @Autowired
    private SingleDiseaseService singleDiseaseService;

    @Autowired
    private SpecialInspectionProjectService specialInspectionProjectService;

    @Autowired
    private TimelinessOfWritingService timelinessOfWritingService;

    @Autowired
    private UnplannedReoperationService unplannedReoperationService;

    @Autowired
    private VtePreventionControlIndicatorsService vtePreventionControlIndicatorsService;

    @Autowired
    private QcRectificationSituationService qcRectificationSituationService;

    @Autowired
    private RectificationMeasuresService rectificationMeasuresService;

    @Autowired
    private ObstetricSpecialService obstetricSpecialService;

    @Override
    public void excel(MultipartFile file, int flag) {
        File f = convert(file);
        if (Objects.isNull(f)) {
            return;
        }
        String fileName = f.getAbsolutePath();
        switch (flag) {
            case 1:
                EasyExcel.read(
                        fileName,
                        MqManagementTeamOffice.class,
                        new MqManagementTeamOfficeListener(mqManagementTeamOfficeService)
                ).sheet().doRead();
                break;
            case 2:
                EasyExcel.read(
                        fileName,
                        ShiftHandoverSystem.class,
                        new ShiftHandoverSystemListener(shiftHandoverSystemService)
                ).sheet().doRead();
                break;
            case 3:
                EasyExcel.read(
                        fileName,
                        DifficultCaseDiscussionSystem.class,
                        new DifficultCaseDiscussionSystemListener(difficultCaseDiscussionSystemService)
                ).sheet().doRead();
                break;
            case 4:
                EasyExcel.read(
                        fileName,
                        DeathCaseDiscussionSystem.class,
                        new DeathCaseDiscussionSystemListener(deathCaseDiscussionSystemService)
                ).sheet().doRead();
                break;
            case 5:
                EasyExcel.read(
                        fileName,
                        OutpatientEmergencyAttendanceAssessment.class,
                        new OutpatientEmergencyAttendanceAssessmentListener(outpatientEmergencyAttendanceAssessmentService)
                ).sheet().doRead();
                break;
            case 6:
                EasyExcel.read(
                        fileName,
                        OutpatientMedicalRecords.class,
                        new OutpatientMedicalRecordsListener(outpatientMedicalRecordsService)
                ).sheet().doRead();
                break;
            case 7:
                EasyExcel.read(
                        fileName,
                        EmergencyMedicalRecords.class,
                        new EmergencyMedicalRecordsListener(emergencyMedicalRecordsService)
                ).sheet().doRead();
                break;
            case 8:
                EasyExcel.read(
                        fileName,
                        SpecialInspectionProject.class,
                        new SpecialInspectionProjectListener(specialInspectionProjectService)
                ).sheet().doRead();
                break;
            case 9:
                EasyExcel.read(
                        fileName,
                        TimelinessOfWriting.class,
                        new TimelinessOfWritingListener(timelinessOfWritingService)
                ).sheet().doRead();
                break;
            case 10:
                EasyExcel.read(
                        fileName,
                        FinalMedicalRecord.class,
                        new FinalMedicalRecordListener(finalMedicalRecordService)
                ).sheet().doRead();
                break;
            case 11:
                EasyExcel.read(
                        fileName,
                        ExtendedHospitalStayManagement.class,
                        new ExtendedHospitalStayManagementListener(extendedHospitalStayManagementService)
                ).sheet().doRead();
                break;
            case 12:
                EasyExcel.read(
                        fileName,
                        VtePreventionControlIndicators.class,
                        new VtePreventionControlIndicatorsListener(vtePreventionControlIndicatorsService)
                ).sheet().doRead();
                break;
            case 13:
                EasyExcel.read(
                        fileName,
                        UnplannedReoperation.class,
                        new UnplannedReoperationListener(unplannedReoperationService)
                ).sheet().doRead();
                break;
            case 14:
                EasyExcel.read(
                        fileName,
                        PostoperativeComplications.class,
                        new PostoperativeComplicationsListener(postoperativeComplicationsService)
                ).sheet().doRead();
                break;
            case 15:
                EasyExcel.read(
                        fileName,
                        MedicalExamApplicationForm.class,
                        new MedicalExamApplicationFormListener(medicalExamApplicationFormService)
                ).sheet().doRead();
                break;
            case 16:
                EasyExcel.read(
                        fileName,
                        MedicalExamApplicationFormFail.class,
                        new MedicalExamApplicationFormFailListener(medicalExamApplicationFormFailService)
                ).sheet().doRead();
                break;
            case 17:
                EasyExcel.read(
                        fileName,
                        DischargedPatients.class,
                        new DischargedPatientsListener(dischargedPatientsService)
                ).sheet().doRead();

                break;
            case 18:
                EasyExcel.read(
                        fileName,
                        ClinicalPathway.class,
                        new ClinicalPathwayListener(clinicalPathwayService)
                ).sheet().doRead();
                break;
            case 19:
                EasyExcel.read(
                        fileName,
                        SingleDisease.class,
                        new SingleDiseaseListener(singleDiseaseService)
                ).sheet().doRead();
                break;
            case 20:
                EasyExcel.read(
                        fileName,
                        BloodTransfusionRatio.class,
                        new BloodTransfusionRatioListener(bloodTransfusionRatioService)
                ).sheet().doRead();
                break;
            case 21:
                EasyExcel.read(
                        fileName,
                        BloodTransfusionRelatedRecords.class,
                        new BloodTransfusionRelatedRecordsListener(bloodTransfusionRelatedRecordsService)
                ).sheet().doRead();
                break;
            case 22:
                EasyExcel.read(
                        fileName,
                        RationalAdministrationDrug.class,
                        new RationalAdministrationDrugListener(rationalAdministrationDrugService)
                ).sheet().doRead();
                break;
            case 23:
                EasyExcel.read(
                        fileName,
                        DoctorPatientRelationship.class,
                        new DoctorPatientRelationshipListener(doctorPatientRelationshipService)
                ).sheet().doRead();
                break;
            case 24:
                EasyExcel.read(
                        fileName,
                        PhPhId.class,
                        new PhPhIdListener(phPhIdService)
                ).sheet().doRead();
                break;
            case 25:
                EasyExcel.read(
                        fileName,
                        QcRectificationSituation.class,
                        new QcRectificationSituationListener(qcRectificationSituationService)
                ).sheet().doRead();
                break;
            case 26:
                EasyExcel.read(
                        fileName,
                        RectificationMeasures.class,
                        new RectificationMeasuresListener(rectificationMeasuresService)
                ).sheet().doRead();
                break;
            case 27:
                EasyExcel.read(
                        fileName,
                        ObstetricSpecial.class,
                        new ObstetricSpecialListener(obstetricSpecialService)
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
