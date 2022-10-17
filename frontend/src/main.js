import Vue from 'vue'
import './utils/dialog.js'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import VueCompositionApi from '@vue/composition-api';
import "./router/premit";
import uploader from 'vue-simple-uploader'
import ViewUI from 'view-design';
import 'view-design/dist/styles/iview.css';


import VueWechatTitle from 'vue-wechat-title'
Vue.use(VueWechatTitle)

Vue.use(ViewUI);
Vue.config.productionTip = false
Vue.use(ElementUI);
Vue.use(VueCompositionApi);
Vue.use(uploader)



new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')