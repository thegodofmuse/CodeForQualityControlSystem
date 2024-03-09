import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import ElementPlus from 'element-plus'
import '../node_modules/element-plus/theme-chalk/index.css'
import store from '@/router/store';


const app = createApp(App)
app.use(router)
app.use(ElementPlus)
app.use(store)
app.mount('#app')



