import { createWebHistory, createRouter } from "vue-router";
import ProductList from "./pages/ProductList.vue";
import ProductPage from "./pages/ProductPage.vue";
const routes = [
    {
        path: "/",
        component: ProductList,
    },
    {
        path: "/product/:id",
        component: ProductPage
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;

