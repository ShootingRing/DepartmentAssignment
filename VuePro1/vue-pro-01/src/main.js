import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from './router/index.js'
import naiveUI from 'naive-ui'

const app = createApp(App);

app.use(router);
app.use(naiveUI);

app.mount('#app');
