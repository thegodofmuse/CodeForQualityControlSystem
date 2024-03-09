<template>
  <div class="container">
    <div class="rectangle-large">上传文件</div>
    <div>
      <input type="file" ref="fileInput" @change="handleFileSelect" />
      <div class="rectangle-large">项目</div>
      <select v-model="selectedOption" class="custom-select">
        <option value="1">医务科的项目</option>
        <option value="2">病案科的项目</option>
        <option value="3">加分项及其原因</option>

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

      const UPLOAD_API = 'http://localhost:8998/api/hrp/uploadProjectScore';

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
  background: linear-gradient(to right, #a8caba, #2E8B57);
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