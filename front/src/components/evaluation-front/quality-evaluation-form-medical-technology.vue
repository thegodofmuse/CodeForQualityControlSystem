<template>
  <div class="button-container">
    <router-link to="/home/evaluation-home/quality-evaluation-form-medical-technology/anesthesiology-front">
      <button class="button" id="anesthesiology_front">
        麻醉科
      </button>
    </router-link>

    <router-link to="/home/evaluation-home/quality-evaluation-form-medical-technology/nutrition_department_front">
      <button class="button" id="nutrition_department_front">
        营养科
      </button>
    </router-link>

    <router-link to="/home/evaluation-home/quality-evaluation-form-medical-technology/cardiac-function-chamber-front">
      <button class="button" id="cardiac_function_chamber_front">
        心功能室
      </button>
    </router-link>

    <router-link to="/home/evaluation-home/quality-evaluation-form-medical-technology/department-of-blood-transfusion-front">
      <button class="button" id="department_of_blood_transfusion_front">
        输血科
      </button>
    </router-link>
    <router-link to="/home/evaluation-home/quality-evaluation-form-medical-technology/department-of-pathology-front">
      <button class="button" id="department_of_pathology_front">
        病理科
      </button>
    </router-link>

    <router-link to="/home/evaluation-home/quality-evaluation-form-medical-technology/dermatology-front">
      <button class="button" id="dermatology_front">
        皮肤科
      </button>
    </router-link>

    <router-link to="/home/evaluation-home/quality-evaluation-form-medical-technology/emergency-department-front">
      <button class="button" id="emergency_department_front">
        急诊科
      </button>
    </router-link>
    <router-link to="/home/evaluation-home/quality-evaluation-form-medical-technology/laboratory-section-front">
      <button class="button" id="laboratory_section_front">
        检验科
      </button>
    </router-link>

    <router-link to="/home/evaluation-home/quality-evaluation-form-medical-technology/outpatient-departments-front">
      <button class="button" id="outpatient_departments_front">
        门诊部门
      </button>
    </router-link>

    <router-link to="/home/evaluation-home/quality-evaluation-form-medical-technology/prenatal-diagnosis-room-front">
      <button class="button" id="prenatal_diagnosis_room_front">
        产前诊断室
      </button>
    </router-link>

    <router-link to="/home/evaluation-home/quality-evaluation-form-medical-technology/radiology-front">
      <button class="button" id="radiology_front">
        放射科
      </button>
    </router-link>
    <router-link to="/home/evaluation-home/quality-evaluation-form-medical-technology/ultrasound-department-front">
      <button class="button" id="ultrasound_department_front">
        超声科
      </button>
    </router-link>
    <router-link to="/home/evaluation-home/quality-evaluation-form-medical-technology/obstetric">
      <button class="button" id="obstetric">
        产科
      </button>
    </router-link>
    <router-link to="/home/evaluation-home/quality-evaluation-form-medical-technology/medical-technology-collection">
      <button class="button" id="medical_technology_collection">
        医技页面合集
      </button>
    </router-link>

  </div>
</template>

<style scoped>
@import "../../../node_modules/@fortawesome/fontawesome-free/css/all.css";

.button-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
}

.button,
.button-import-clinic-data,
.button-quality-evaluation-form,
.button-data-visualization {
  background-color:	#A2CD5A;
  border: 5px solid #797979;
  border-radius: 10px;
  height: 200px;
  width: 200px;
  margin: 15px;

  font-family: "微软雅黑", sans-serif;
  font-size: 20px;
  font-weight: bold;

  display: flex;
  flex-direction: column;
  align-items: center;

  justify-content: center; /* 新增的属性 */
  text-align: center; /* 新增的属性 */

}

/* 去除路由链接 <router-link>自带的下划线 */
.button-container a {
  text-decoration: none;
}
</style>
<script setup>
</script>