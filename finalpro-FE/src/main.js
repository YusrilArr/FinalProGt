import '@babel/polyfill'
import 'mutationobserver-shim'
import Vue from 'vue'
import './plugins/bootstrap-vue'
import App from './App.vue'
import VueRouter from "vue-router";
import Routes from "./routes.js";

Vue.config.productionTip = false

Vue.use(VueRouter);

const router = new VueRouter({
  routes : Routes,
  mode : "history"
});

new Vue({
  render: h => h(App),
  router : router,
}).$mount('#app')
