package com.example.qualitycontrolsystem.login.controller;

import com.example.qualitycontrolsystem.login.service.clinic_form_service.UploadClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UploadController {
    @Autowired
    private UploadClinicService uploadClinicService;

    /**
     * 1. 科室医疗 mq_management_team_office
     * 2. 交接班 shift_handover_system
     * 3. 疑难病 difficult_case_discussion_system
     * 4. 死亡病例讨论制度 death_case_discussion_system
     * 5. 门急诊出勤考核 outpatient_emergency_attendance_assessment
     * 6. 门诊病历 outpatient_medical_records
     * 7. 急诊病历 emergency_medical_records
     * 8. 专项督查项目 special_inspection_project
     * 9. 书写及时性 timeliness_of_writing
     * 10. 终末病历 final_medical_record
     * 11. 住院超30天管理 extended_hospital_stay_management
     * 12. VTE防控指标 vte_prevention_control_indicators
     * 13. 非计划再手术 unplanned_reoperation
     * 14. 术后并发症 postoperative_complications
     * 15. 病检申请单 medical_exam_application_form
     * 16. 病检申请单不合格个例 medical_exam_application_form_fail
     * 17. 临床路径 clinical_pathway
     * 18. 出院人数 discharged_patients
     * 19. 单病种 single_disease
     * 20. 输血比例和输血情况 blood_transfusion_ratio
     * 21. 输血相关记录 blood_transfusion_related_records
     * 22. 合理用药 rational_administration_drug
     * 23. 医患关系 doctor_patient_relationship
     * 24. 公卫、预防保健、传染病 ph_ph_id
     *
     * @param file 上传的文件
     * @param flag 标志位
     */

    @PostMapping("/upload/clinic")
    public void excel(MultipartFile file, @RequestParam("flag") int flag){
        uploadClinicService.excel(file,flag);
    }

}
