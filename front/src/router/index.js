import { createRouter, createWebHashHistory } from 'vue-router'
import test from '../components/test.vue'
import login from '../components/login.vue'
import home from '../components/home.vue'
import EvaluationHome from "@/components/evaluation-front/evaluation-home.vue";
import ChangeOfficeName from "@/components/evaluation-front/change-office-name.vue"
import ImportClinicData from "@/components/evaluation-front/import-clinic-data.vue";
import DataVisualization from "@/components/evaluation-front/data-visualization.vue";
import ImportDataVisualization from "@/components/evaluation-front/import-data-visualization.vue";
import ExportDataForInspection from "@/components/evaluation-front/export-data-for-inspection.vue";
import QualityEvaluationFormClinic from "@/components/evaluation-front/quality-evaluation-form-clinic.vue";
import QualityEvaluationFormMedicalTechnology
    from "@/components/evaluation-front/quality-evaluation-form-medical-technology.vue";
import ExcelLayout from "@/components/evaluation-front/excel-layout.vue";
import AnesthesiologyFront
    from "@/components/evaluation-front/medical-technology/anesthesiology-front.vue";
import NutritionDepartmentFront
    from "@/components/evaluation-front/medical-technology/nutrition_department_front.vue"
import CardiacFunctionChamberFront
    from "@/components/evaluation-front/medical-technology/cardiac-function-chamber-front.vue";
import DepartmentOfBloodTransfusionFront
    from "@/components/evaluation-front/medical-technology/department-of-blood-transfusion-front.vue";
import DepartmentOfPathologyFront
    from "@/components/evaluation-front/medical-technology/department-of-pathology-front.vue";
import DermatologyFront from "@/components/evaluation-front/medical-technology/dermatology-front.vue";
import EmergencyDepartmentFront from "@/components/evaluation-front/medical-technology/emergency-department-front.vue";
import LaboratorySectionFront from "@/components/evaluation-front/medical-technology/laboratory-section-front.vue";
import OutpatientDepartmentsFront
    from "@/components/evaluation-front/medical-technology/outpatient-departments-front.vue";
import PrenatalDiagnosisRoomFront
    from "@/components/evaluation-front/medical-technology/prenatal-diagnosis-room-front.vue";
import RadiologyFront from "@/components/evaluation-front/medical-technology/radiology-front.vue";
import UltrasoundDepartmentFront
    from "@/components/evaluation-front/medical-technology/ultrasound-department-front.vue";
import ObstetricFront from "@/components/evaluation-front/medical-technology/obstetric.vue";
import AssessmentHrp from "@/components/hrp-front/assessment-hrp.vue";
import ImportGrades from "@/components/hrp-front/import-grades.vue";
import GradesForm from "@/components/hrp-front/grades-form.vue";
import EncryptForm from "@/components/hrp-front/encrypt-form.vue";
import SetTotalScore from "@/components/hrp-front/set-total-score.vue";
import MedicalTechnologyCollection
    from "@/components/evaluation-front/medical-technology/medical-technology-collection.vue";

const routes = [
    {
        path: '/test',
        name: 'Test',
        component: test
    },
    {
        path:'/login',
        name:'Login',
        component:login
    },
    {
        path:'/home',
        name:'Home',
        component: home,
    },
    { path: '/home/assessment-hrp',
        component: AssessmentHrp
    },
    { path: '/home/evaluation-home',
        component: EvaluationHome
    },
    //assessment-hrp之后的同级路由
    { path: '/home/assessment-hrp/import-grades',
        component: ImportGrades
    },
    { path: '/home/assessment-hrp/grades-form',
        component: GradesForm
    },
    { path: '/home/assessment-hrp/encrypt-form',
        component: EncryptForm
    },
    { path: '/home/assessment-hrp/set-total-score',
        component: SetTotalScore
    },
    //evaluation-home之后的同级路由
    { path: '/home/evaluation-home/change-office-name',
        component: ChangeOfficeName
    },
    { path: '/home/evaluation-home/import-clinic-data',
        component: ImportClinicData
    },
    { path: '/home/evaluation-home/quality-evaluation-form-clinic',
        component: QualityEvaluationFormClinic
    },
    { path: '/home/evaluation-home/quality-evaluation-form-medical-technology',
        component: QualityEvaluationFormMedicalTechnology
    },
    { path: '/home/evaluation-home/excel-layout',
        component: ExcelLayout
    },

    { path: '/home/evaluation-home/data-visualization',
        name: 'DataVisualization',
        component: DataVisualization,
        props: route => ({ page: Number(route.query.page) }), // 转换查询参数为数字
    },
    { path: '/home/evaluation-home/import-data-visualization',
        component: ImportDataVisualization
    },
    { path: '/home/evaluation-home/export-data-for-inspection',
        component: ExportDataForInspection
    },
    //医技质控反馈单之后的子路由quality-evaluation-form-medical-technology
    { path: '/home/evaluation-home/quality-evaluation-form-medical-technology/anesthesiology-front',
        component: AnesthesiologyFront
    },
    { path: '/home/evaluation-home/quality-evaluation-form-medical-technology/nutrition_department_front',
        component: NutritionDepartmentFront
    },
    { path: '/home/evaluation-home/quality-evaluation-form-medical-technology/cardiac-function-chamber-front',
        component: CardiacFunctionChamberFront
    },
    { path: '/home/evaluation-home/quality-evaluation-form-medical-technology/department-of-blood-transfusion-front',
        component: DepartmentOfBloodTransfusionFront
    },
    { path: '/home/evaluation-home/quality-evaluation-form-medical-technology/department-of-pathology-front',
        component: DepartmentOfPathologyFront
    },
    { path: '/home/evaluation-home/quality-evaluation-form-medical-technology/dermatology-front',
        component: DermatologyFront
    },
    { path: '/home/evaluation-home/quality-evaluation-form-medical-technology/emergency-department-front',
        component: EmergencyDepartmentFront
    },
    { path: '/home/evaluation-home/quality-evaluation-form-medical-technology/laboratory-section-front',
        component: LaboratorySectionFront
    },
    { path: '/home/evaluation-home/quality-evaluation-form-medical-technology/outpatient-departments-front',
        component: OutpatientDepartmentsFront
    },
    { path: '/home/evaluation-home/quality-evaluation-form-medical-technology/prenatal-diagnosis-room-front',
        component: PrenatalDiagnosisRoomFront
    },
    { path: '/home/evaluation-home/quality-evaluation-form-medical-technology/radiology-front',
        component: RadiologyFront
    },
    { path: '/home/evaluation-home/quality-evaluation-form-medical-technology/ultrasound-department-front',
        component: UltrasoundDepartmentFront
    },
    { path: '/home/evaluation-home/quality-evaluation-form-medical-technology/obstetric',
        component: ObstetricFront
    },
    { path: '/home/evaluation-home/quality-evaluation-form-medical-technology/medical-technology-collection',
        component: MedicalTechnologyCollection
    },



    // ...其他路由
]

const router = createRouter({
    history: createWebHashHistory(),
    routes,
})

export default router

