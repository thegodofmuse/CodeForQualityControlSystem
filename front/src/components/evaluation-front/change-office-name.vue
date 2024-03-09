<template>
  <div class="green-background">
    <div class="rectangle-large">替换字符</div>
    <input type="file" @change="handleFileChange" />
    <div class="centered-button">
      <button @click="submitForm">提交</button>
    </div>
    <div class="separation"></div> <!-- 添加隐形方框 -->

<!--    <div class="rectangle-large">替换编码</div>-->
<!--    <input type="file" @change="fileChange" />-->
<!--    <div class="centered-button">-->
<!--      <button @click="submitFile">提交</button>-->
<!--    </div>-->
    <!-- 页面内容 -->
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      file: null
    };
  },
  methods: {
    handleFileChange(event) {
      this.file = event.target.files[0];
    },
    submitForm() {
      const data = new FormData();
      data.append('file', this.file);

      axios.post('http://localhost:8998/api/change/name', data)
          .then(response => {
            if (response.data.statusCode == 200) {
              alert('操作成功！');
            } else {
              alert('操作失败！');
            }
          })
          .catch(error => {
            alert('操作失败！');
            console.error(error);
          });
    }
    // fileChange(event) {
    //   this.file = event.target.files[0];
    // },
    // submitFile() {
    //   const data = new FormData();
    //   data.append('file', this.file);
    //
    //   axios.post('http://localhost:8998/api/change/encoding', data)
    //       .then(response => {
    //         if (response.data.statusCode == 200) {
    //           alert('操作成功！');
    //         } else {
    //           alert('操作失败！');
    //         }
    //       })
    //       .catch(error => {
    //         alert('操作失败！');
    //         console.error(error);
    //       });
    // }


  }
}

</script>

<style scoped>
.green-background {
  background-color: #2E8B57;
  width: 100%;
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.centered-button {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 20px;
}

button {
  width: 60px;
  height: 30px;
}
.rectangle-large {
  color: white;
  font-weight: bold;
  font-size: 24px;
  text-align: center; /* 水平居中对齐文本 */
}
.separation {
  height: 100px;
  background-color: transparent;
}
</style>



