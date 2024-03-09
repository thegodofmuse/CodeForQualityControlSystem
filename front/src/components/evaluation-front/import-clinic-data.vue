<template>
  <div class="container">
    <div class="rectangle-large">上传文件</div>
    <div>
      <input type="file" ref="fileInput" @change="handleFileSelect" />
      <div class="rectangle-large">项目</div>
      <select v-model="selectedOption" class="custom-select">
        <option value="1">科室医疗质量管理小组工作</option>
        <option value="2">交接班制度</option>
        <option value="3">疑难病例讨论制度</option>
        <option value="4">死亡病例讨论制度</option>
        <option value="5">门急诊出勤考核</option>
        <option value="6">门诊病历</option>
        <option value="7">急诊病历</option>
        <option value="8">专项督查项目</option>
        <option value="9">书写及时性</option>
        <option value="10">终末病历</option>
        <option value="11">住院超30天管理</option>
        <option value="12">VTE防控指标</option>
        <option value="13">非计划再手术</option>
        <option value="14">术后并发症</option>
        <option value="15">病检申请单</option>
        <option value="16">病检申请单不合格个例</option>

        <option value="17">出院人数</option>
        <option value="18">临床路径</option>

        <option value="19">单病种</option>
        <option value="20">输血比例和输血情况</option>
        <option value="21">输血相关记录</option>
        <option value="22">合理用药</option>
        <option value="23">医患关系</option>
        <option value="24">公卫、预防保健、传染病</option>
        <option value="25">质控科追踪上月整改情况</option>
        <option value="26">科室整改措施</option>
        <option value="27">产科特别指标</option>
      </select>
      <button @click="handleSubmit">提交</button>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      selectedOption: null, // 单选下拉框的选中值
    };
  },
  methods: {
    handleFileSelect(event) {
      const file = event.target.files[0];
      // 在这里可以对文件进行处理，例如验证文件类型、大小等
      console.log(file);
    },
    handleSubmit() {
      const file = this.$refs.fileInput.files[0];
      if (!file) {
        alert('请先选择文件');
        return;
      }

      const formData = new FormData();
      formData.append('file', file);
      formData.append('flag', parseInt(this.selectedOption)); // 添加选中的值

      console.log('提交的数据:', Object.fromEntries(formData));

      const UPLOAD_API = 'http://localhost:8998/api/upload/clinic';

      const config = {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      };

      axios
          .post(UPLOAD_API, formData)
          .then(response => {
            this.$message.success('上传成功');
            this.$refs.fileInput.value = ''; // 清空文件选择器
            this.selectedOption = ''; // 清空选中的值
          })
          .catch(error => {
            this.$message.error('上传失败');
          });
    }

  }
}
</script>





<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  gap: 20px;
  height: calc(100vh ); /* 将容器高度减去30px */
  background-color: #2E8B57;
  margin-top: 30px; /* 向上移动30px */
}

.rectangle-large {
  color: white;
  font-weight: bold;
  font-size: 24px;
  text-align: center; /* 水平居中对齐文本 */
}

.custom-select {
  font-size: 18px;
}

</style>

<script setup>
</script>