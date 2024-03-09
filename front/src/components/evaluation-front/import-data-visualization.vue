<!--本文件中代码没有改变量名！记得改变量名！-->
<template>
  <div class="container">
    <div class="rectangle-short">项目</div>
    <!-- 单选下拉框 -->
    <div class="select-box">
      <el-select v-model="selectedOption" placeholder="请选择">
        <el-option
            v-for="item in items"
            :key="item.value"
            :label="item.text"
            :value="item.value">
        </el-option>
      </el-select>
      <p v-if="selectedOption">已选项: {{ selectedOption }}</p>
    </div>

    <div class="rectangle-short">日期</div>

    <!-- 日期选择器（按月） -->
    <div class="date-picker">
      <el-date-picker
          v-model="selectedMonth"
          type="month"
          placeholder="选择月份"
          @change="onChange">
      </el-date-picker>
      <p v-if="selectedMonth">已选择: {{ formattedMonth }}</p>
    </div>


    <!-- 上传文件 --><!--        文件传输地址-->
    <el-upload
        ref="upload"
        class="upload-demo"
        action="https://jsonplaceholder.typicode.com/posts/"
        :on-success="handleSuccess"
        :before-upload="beforeUpload"
    >
      <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
      <div slot="tip" class="el-upload__tip">只能上传xlsx/xls文件</div>
      <p v-if="fileName">已选择: {{ fileName }}</p>
    </el-upload>

    <!-- 提交按钮 -->
    <el-button class="submit-button" type="primary" @click="onSubmit">提交</el-button>
  </div>
</template>

<script>
import { ref } from 'vue';
import axios from "axios";

export default {
  data() {
    return {
      //单选下拉框
      items: [
        { text: "A", value: "a" },
        { text: "B", value: "b" },
        { text: "C", value: "c" },
      ],
      //日期选择器
      selectedOption: '',
      selectedMonth: '',
      selectedDate: '',
      //文件名
      fileName: '',
      //传文件
      selectedFile: null,
    };
  },

  computed: {
    formattedMonth() {
      if (this.selectedMonth) {
        const date = new Date(this.selectedMonth);
        const year = date.getFullYear();
        const month = date.getMonth() + 1;  // JavaScript 的月份是从 0 开始的，所以需要加 1
        return `${year}年${month < 10 ? '0' + month : month}月`;  // 如果月份小于 10，前面添加一个 0
      }
      return '';
    },
  },


  methods: {
    onChange(value) {
      console.log('selectedMonth after change:', this.selectedMonth);
    },
    //上传文件
    handleSuccess(response, file, fileList) {
      // 保存文件名
      this.fileName = file.name;
      // 假设服务器返回的response包含文件路径
      const filePath = response.path;
      console.log(filePath);

      // 假设你有一个方法向后端发送文件路径
      this.sendFilePathToServer(filePath);
      //定义selectedFile 属性
      this.selectedFile = file.raw;
    },
    beforeUpload(file) {
      const isXLSX = file.type === 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet';
      const isXLS = file.type === 'application/vnd.ms-excel';
      if (!isXLSX && !isXLS) {
        this.$message.error('上传文件只能是 xlsx/xls 格式!');
        return false;  // 添加这行代码来阻止上传
      }
    },

    submitUpload() {
      this.$refs.upload.submit();
    },
    sendFilePathToServer(filePath) {
      // 在这里将文件路径发送给后端
    },
    //接口
    onSubmit() {
      if (!this.selectedOption || !this.selectedMonth || !this.selectedFile) {
        this.$message.error('请先选择项目、日期和文件！');
        return;  // 阻止提交
      }
      // 创建一个 FormData 对象来存储要发送的数据
      const formData = new FormData();
      formData.append('medicalProject', this.selectedOption);
      formData.append('date', this.selectedMonth);
      formData.append('file', this.selectedFile);  // 假设 selectedFile 存储了用户选择的文件

      // 使用 axios 发送 POST 请求
      axios.post('/api/import-clinic-data', formData)
          .then(response => {
            console.log(response.data);
            // 处理服务器的响应数据
          })
          .catch(error => {
            console.error(error);
            // 处理错误
          });
    }
  },


}
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  background-color: #2E8B57;
}

.select-box .el-select .el-input,
.date-picker .el-date-picker .el-input {
  width: 400px !important;
  height: 45px !important;
  margin-bottom: 50px;
}
/* 上传文件的样式 */
.upload-demo {
  padding-top: 30px;
  margin-bottom: 50px;
}
.rectangle-short {
  font: 100 24px/100px sans-serif;/*文字相关设置*/
  text-align: center; /*文字居中对齐*/
  color: white; /*文字设置为白色*/
  font-weight: bold;/* 文本加粗 */
  line-height: 80px; /* 设置行高与文本框的高度相同 */
  width: 400px;
  height: 80px;
  background-color:	#2E8B57; /* Replace with the color you want */
  margin-bottom: 50px; /* Add some space between the large rectangle and the others */
  margin: 0px auto; /* vertical margin is 50px, horizontal margin is auto */
  margin-bottom: 50px;
}
.submit-button {
  margin-bottom: 50px;
  background-color: #006400 !important;
  color: #fff !important;
}

</style>