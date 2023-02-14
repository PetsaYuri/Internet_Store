<template>
  <div class="d-flex flex-row flex-wrap">
    <!--   <product-form :products="products" />
    <products-item
      v-for="product in products"
      :key="product.id"
      :product="product"
    /> -->

    <products-item
      v-for="product in products"
      :key="product.id"
      :product="product"
    />
  </div>
</template>

<script>
import http from "http-common.js";
import ProductsItem from "components/products/ProductItem.vue";
import ProductForm from "components/products/ProductForm.vue";
export default {
  components: {
    ProductsItem,
    ProductForm,
  },
  data: function () {
    return {
      products: null,
    };
  },
  created: function () {
    var locat = document.location.href;
    var arr = locat.split("8080/");

    http.get("/store" + arr[1]).then((res) => (this.products = res.data));
  },
};
</script>

<style>
</style>