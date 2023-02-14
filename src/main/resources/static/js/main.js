import 'vuetify/styles'
import { createApp } from 'vue'
import { createVuetify } from 'vuetify'
import router from './router'
import App from 'pages/App.vue'
//import { BootstrapVue } from 'bootstrap-vue'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
//import "../css/bootstrap.min.css"

const app = createApp(App)
const vuetify = createVuetify({
    components,
    directives,
})
//const bootstrap = BootstrapVue

app.use(vuetify)
app.use(router)
//app.use(bootstrap)

app.mount('#app')