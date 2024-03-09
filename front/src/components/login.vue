<template>
  <body>
  <div class="container">
    <h1>欢迎使用质控系统</h1>
    <form @submit.prevent="login" class="form">
      <input v-model="username" placeholder="用户名" />
      <input v-model="password" placeholder="密码" type="password" />
      <button type="submit">登录</button>
    </form>
  </div>
  <footer>
    <p>未经许可，禁止商用</p>
    <p>如有需要，请联系开发者</p>
  </footer>
  </body>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      username: '',
      password: '',
      errorMessage: '' // 添加 errorMessage 变量
    }
  },
  methods: {
    login() {
      console.log(`Sending login request for user ${this.username}`);
      axios.post('http://localhost:8998/api/login', {
        username: this.username,
        password: this.password
      })
          .then(response => {
            if (response.data.message === '登录成功') {
              // 登录成功，跳转到 home 页面
              this.$router.push('/home');
            }else{
              // 登录失败，显示错误信息
              this.errorMessage = response.data.message;
            }
          })
          .catch(error => {
            console.error("Error during login:", error);
          });

    }
  }
};

</script>
<style scoped>
.container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: rgb(0, 139, 69);
}

.form {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-top:20px;
}

h1 {
  margin-top: 0;
  display: flex;
  justify-content: center;
  align-items: flex-start;
}
input {
  width: 200px;
  height: 30px;
  padding: 5px;
  border: none;
  border-radius: 5px;
  background-color: #fff;
  margin-bottom: 40px;
}

button {
  padding: 20px 40px;
  border: none;
  border-radius: 5px;
  background-color: #006400;
  color: #fff;
  font-size: 16px;
  cursor: pointer;
}

footer {
  text-align: center;
  margin-top: 10px;
}
body {
  position: relative;
  min-height: 100vh;
  background-color: rgb(0, 139, 69);
}
</style>