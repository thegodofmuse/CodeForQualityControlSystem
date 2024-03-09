<template>
<div class="buttons-container">
  <router-link to="/home/assessment-hrp/import-grades">
  <button class="button button-hover">导入成绩</button>
  </router-link>

  <router-link to="/home/assessment-hrp/grades-form">
  <button class="button button-hover">每月人事系统绩效</button>
  </router-link>

  <router-link to="/home/assessment-hrp/encrypt-form">
  <button class="button button-hover">加密表单</button>
  </router-link>

  <router-link to="/home/assessment-hrp/set-total-score">
  <button class="button button-hover">设置质控单总分</button>
  </router-link>
</div>
</template>
<script setup>

</script>



<style scoped>
.buttons-container {
  display: flex;
  justify-content: center;
}

.button {
  margin: 0 55px; /* 按钮之间的间隔 */
  background-color:		#66CDAA;
  border: 5px solid 	#66CDAA;
  border-radius: 10px;
  height: 600px;
  width:270px;
  font-weight: bold; /* 加粗 */
  font-size:20px;/* 字体大小 */
}
/* 提升交互体验 */
.button-hover:hover {
  background-color: 	#458B74; /* 鼠标悬停时的背景颜色 */
  /* 可根据需要调整其他鼠标悬停时的样式，如字体颜色、边框等 */
}

</style>