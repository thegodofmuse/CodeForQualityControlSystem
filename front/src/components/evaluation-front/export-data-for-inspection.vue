<template>
  <div>
    <div>
      <!-- 其他内容 -->
      <button @click="goBack">返回</button>
    </div>
    <el-tabs v-model="activeTab" @tab-click="handleTabChange">
      <el-tab-pane label="四川省三级医院等级评审" name="tertiaryHospital">
        <TertiaryHospital />
      </el-tab-pane>
      <el-tab-pane label="其他检查" name="otherInspection">
        <OtherInspection />
      </el-tab-pane>


    </el-tabs>
  </div>
</template>

<script>


import TertiaryHospital from "@/components/evaluation-front/inspection/tertiary-hospital.vue";
import OtherInspection from "@/components/evaluation-front/inspection/other-inspection.vue";

export default {
  data() {
    return {
      activeTab: 'tertiaryHospital',
      pageMap: {
        tertiaryHospital: 1,
        otherInspection: 2,
      },
      currentPage: 1,
      totalPages: 2,
    };
  },
  components: {
    TertiaryHospital,
    OtherInspection
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
      const route = `/home/evaluation-home/export-data-for-inspection?page=${this.currentPage}`;
      this.$router.push(route);
    },
  },
};
</script>

<style scoped>
/* 可选：主组件的样式 */
</style>
