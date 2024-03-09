<template>
  <div>
    <div>
      <!-- 其他内容 -->
      <button @click="goBack">返回</button>
    </div>
    <el-tabs v-model="activeTab" @tab-click="handleTabChange">
      <el-tab-pane label="单病种" name="singleDisease">
        <SingleDiseaseVisualization />
      </el-tab-pane>
      <el-tab-pane label="VTE" name="vte">
        <VTEVisualization />
      </el-tab-pane>
      <el-tab-pane label="手术并发症" name="surgicalComplications">
        <SurgicalComplicationsVisualization />
      </el-tab-pane>
      <el-tab-pane label="非计划再手术" name="unplannedReoperation">
        <UnplannedReoperation />
      </el-tab-pane>
      <el-tab-pane label="住院超30天" name="extendedHospitalStay">
        <ExtendedHospitalStay />
      </el-tab-pane>
      <el-tab-pane label="病案相关" name="medicalRecordsRelated">
        <MedicalRecordsRelated />
      </el-tab-pane>
      <el-tab-pane label="缺陷警告" name="defectWarning">
        <DefectWarning />
      </el-tab-pane>
      <el-tab-pane label="日间手术" name="daySurgery">
        <DaySurgery />
      </el-tab-pane>
      <el-tab-pane label="输血质量管理" name="bloodTransfusionQualityManagement">
        <BloodTransfusionQualityManagement />
      </el-tab-pane>
      <el-tab-pane label="病理送检" name="pathologicalExamination">
        <PathologicalExamination />
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import SingleDiseaseVisualization from './visualization/single-disease-visualization.vue';
import VTEVisualization from './visualization/vte-visualization.vue';
import SurgicalComplicationsVisualization from './visualization/surgical-complications-visualization.vue';
import UnplannedReoperation from './visualization/unplanned-reoperation.vue'
import ExtendedHospitalStay from "@/components/evaluation-front/visualization/extended-hospital-stay.vue";
import MedicalRecordsRelated from "@/components/evaluation-front/visualization/medical-records-related.vue";
import DefectWarning from "@/components/evaluation-front/visualization/defect-warning.vue";
import DaySurgery from "@/components/evaluation-front/visualization/day-surgery.vue";
import BloodTransfusionQualityManagement
  from "@/components/evaluation-front/visualization/blood-transfusion-quality-management.vue";
import PathologicalExamination from "@/components/evaluation-front/visualization/pathological-examination.vue";

export default {
  data() {
    return {
      activeTab: 'singleDisease',
      pageMap: {
        singleDisease: 1,
        vte: 2,
        surgicalComplications: 3,
        unplannedReoperation:4,
        extendedHospitalStay:5,
        medicalRecordsRelated:6,
        defectWarning:7,
        daySurgery:8,
        bloodTransfusionQualityManagement:9,
        pathologicalExamination:10
      },
      currentPage: 1,
      totalPages: 10,
    };
  },
  components: {
    SingleDiseaseVisualization,
    VTEVisualization,
    SurgicalComplicationsVisualization,
    UnplannedReoperation,
    ExtendedHospitalStay,
    MedicalRecordsRelated,
    DefectWarning,
    DaySurgery,
    BloodTransfusionQualityManagement,
    PathologicalExamination
  },
  methods: {
    //返回按钮
    goBack() {
      this.$router.push('/home/evaluation-home');
    },
    //处理选项卡
    handleTabChange(tab) {
      console.log('tab 对象:', tab);
      console.log('选项卡名称:', tab.props.name);
      this.currentPage = this.pageMap[tab.props.name];
      this.updateRoute();
    },
    updateRoute() {
      const route = `/home/evaluation-home/data-visualization?page=${this.currentPage}`;
      this.$router.push(route);
    },
  },
};
</script>

<style scoped>
/* 可选：主组件的样式 */
</style>




