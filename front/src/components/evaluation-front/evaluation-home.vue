<template>


  <div class="button-container">
    <router-link to="/home/evaluation-home/change-office-name">
      <button class="button-import-clinic-data button-hover" id="change_office_name">
        <i class="fa-solid fa-eraser"></i>整合科室名称
      </button>
    </router-link>

    <router-link to="/home/evaluation-home/import-clinic-data">
      <button class="button-import-clinic-data button-hover" id="import_clinic_data">
        <i class="fa-solid fa-plus"></i>自动导入数据-质控反馈单用（临床）
      </button>
    </router-link>

    <router-link to="/home/evaluation-home/quality-evaluation-form-clinic">
      <button class="button-quality-evaluation-form button-hover" id="quality_evaluation_form_clinic">
        <i class="fa-solid fa-pager"></i>每月质量管理考核反馈单（临床）
      </button>
    </router-link>

    <router-link to="/home/evaluation-home/quality-evaluation-form-medical-technology">
      <button class="button-quality-evaluation-form button-hover" id="quality_evaluation_form_medical_technology">
        <i class="fa-solid fa-pager"></i>每月质量管理考核反馈单（医技+临床特殊科室）
      </button>
    </router-link>

    <router-link to="/home/evaluation-home/excel-layout">
      <button class="button-quality-evaluation-form button-hover" id="excel_layout">
        <i class="fa-solid fa-receipt"></i>处理excel表格格式
      </button>
    </router-link>



    <router-link to="/home/evaluation-home/data-visualization">
      <button class="button-data-visualization button-hover" id="data_visualization">
        <i class="fa-solid fa-magnifying-glass-chart"></i>医疗质量数据看板
      </button>
    </router-link>

    <router-link to="/home/evaluation-home/import-data-visualization">
      <button class="button button-hover" id="import_data_visualization">
        自动导入数据-数据分析用
      </button>
    </router-link>

    <router-link to="/home">
      <button class="button button-hover" id="export-data-for-inspection">
        返回质控系统首页
      </button>
    </router-link>



    <router-link to="/home/evaluation-home/export-data-for-inspection">
      <button class="button button-hover" id="export-data-for-inspection">
        常规迎检数据导出
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
  height: 300px;
  width: 300px;
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
.button-import-clinic-data i,
.button-quality-evaluation-form i,
.button-data-visualization i
{
  font-size: 60px; /* 根据需要调整图标的大小 */
  margin-bottom: 60px; /* 调整图标与文字之间的垂直间距 */
}
/* 去除路由链接 <router-link>自带的下划线 */
.button-container a {
  text-decoration: none;
}
/* 提升交互体验 */
.button-hover:hover {
  background-color: #7DAD44; /* 鼠标悬停时的背景颜色 */
  /* 可根据需要调整其他鼠标悬停时的样式，如字体颜色、边框等 */
}
</style>
<script setup>
</script>