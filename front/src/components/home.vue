<template>
  <div class="rectangle-large">质控系统首页</div>
  <div class="container">
    <div class="rectangle-container">

      <router-link to="/home/assessment-hrp">
        <button class="button-connect-hrp button-hover" id="connect_hrp">
          <i class="fas fa-ruler"></i>考核及评价
        </button>
      </router-link>

      <router-link to="/home/evaluation-home">
        <button class="button-quality-evaluation button-hover" id="quality_evaluation">
          <i class="fas fa-scroll"></i>质量评估
        </button>
      </router-link>

      <button class="button-clinical-pathway-management button-hover" id="clinical_pathway_management"><i class="fas fa-map"></i>临床路径管理</button>
      <button class="button-medical-record-quality-management button-hover" id="medical_record_quality_management"><i class="fas fa-book-medical"></i>病历质量管理</button>
      <button class="button button-hover" id="metachysis_quality_management">输血质量管理</button>
      <button class="button button-hover" id="perioperative_period">围手术期质量</button>
      <button class="button button-hover" id="pathology_examination">病理送检</button>
      <button class="button button-hover" id="core_institution_implement">核心制度执行</button>
      <button class="button button-hover" id="training_management">培训管理</button>
      <button class="button button-hover" id="quality_control_center">各质控中心</button>
      <button class="button button-hover" id="defect_warning">缺陷警告</button>
      <button class="button button-hover" id="personal_homepage">个人主页</button>
    </div>
    <div class="footer">
      未经许可，禁止商用。如有需要，请联系开发者
    </div>

  </div>
</template>

<script>
export default {
  name: 'Home',
}
</script>

<style scoped>
@import "../../node_modules/@fortawesome/fontawesome-free/css/all.css";

.container {
  min-height: 100vh; /* 设置容器的最小高度为视口高度，确保至少撑满一屏 */
  display: flex;
  flex-direction: column;
}

.rectangle-large {
  font: 100 24px/100px sans-serif;/*文字相关设置*/
  text-align: center; /*文字居中对齐*/
  color: white; /*文字设置为白色*/
  font-weight: bold;/* 文本加粗 */
  line-height: 80px; /* 设置行高与文本框的高度相同 */
  width: 930px;
  height: 80px;
  background-color:#96CDCD; /* Replace with the color you want */
  margin-bottom: 50px; /* Add some space between the large rectangle and the others */
  margin: 0px auto; /* vertical margin is 50px, horizontal margin is auto */
}

.rectangle-container {
  display: flex;
  flex-wrap: wrap;
  width: 950px; /* 12个按钮所在范围 */
  justify-content: space-between;
  margin: 50px auto;
  position: relative; /* 设置相对定位 */
  flex-grow: 1; /* 让 .rectangle-container 填充剩余空间 */
}

.button-connect-hrp {
  font: 24px/100px sans-serif;/*文字相关设置*/
  color: white; /*文字设置为白色*/
  width:200px;
  height: 130px;
  background-color: #00868B;
  border-radius: 4px ;/*圆角值*/
  border:#00868B;
  margin-bottom: 60px;
  margin-right: 50px; /* Add some space between .rectangle elements */
  margin-top: 50px;   /*每行间距*/
  margin-left: 17px;
  margin-right: 21px;
}

.button-quality-evaluation {
  font: 100 24px/100px sans-serif;
  color: white; /*文字设置为白色*/
  width: 200px;
  height: 130px;
  background-color: #00868B;
  border-radius: 4px ;/*圆角值*/
  border:#00868B;
  margin-bottom: 60px;
  margin-right: 50px; /* Add some space between .rectangle elements */
  margin-top: 50px;   /*每行间距*/
  margin-left: 17px;
  margin-right: 20px;
}

.button-clinical-pathway-management {
  font: 100 24px/100px sans-serif;
  color: white; /*文字设置为白色*/
  width: 200px;
  height: 130px;
  background-color: #00868B;
  border-radius: 4px ;/*圆角值*/
  border:#00868B;
  margin-bottom: 60px;
  margin-right: 50px; /* Add some space between .rectangle elements */
  margin-top: 50px;   /*每行间距*/
  margin-left: auto;
  margin-right: auto;
}

.button-medical-record-quality-management {
  font: 100 24px/100px sans-serif;
  color: white; /*文字设置为白色*/
  width: 200px;
  height: 130px;
  background-color: #00868B;
  border-radius: 4px ;/*圆角值*/
  border:#00868B;
  margin-bottom: 60px;
  margin-right: 50px; /* Add some space between .rectangle elements */
  margin-top: 50px;   /*每行间距*/
  margin-left: auto;
  margin-right: auto;
}

.button {
  font: 100 24px/100px sans-serif;
  color: white; /*文字设置为白色*/
  width: 200px;
  height: 100px;
  background-color: #00868B;
  border-radius: 4px ;/*圆角值*/
  border:#00868B;
  margin-bottom: 60px;
  margin-right: 50px; /* Add some space between .rectangle elements */
  margin-top: 50px;   /*每行间距*/
  margin-left: auto;
  margin-right: auto;
}
.footer {
  text-align: center;
  background-color: white;
  padding: 20px;
}
.button-hover:hover {
  background-color: #00353B;
}

</style>


