<template>
  <div>
    <div>
      <!--  <product-delete :product="product" />
      <product-update :product="product" /> -->
      <v-card
        @click="watchProduct(product.id)"
        height="300"
        width="210px"
        border="true"
        class="ml-5 mb-5"
      >
        <v-img src="/img/TV.webp"></v-img>
        <v-card-title class="text-center">{{ product.title }}</v-card-title>
        <v-card-text v-if="product.discount != 0">
          <h2 class="line-through">{{ product.price }}₴</h2>
          <h2 class="text-danger">{{ product.priceWithDiscount }}₴</h2>
        </v-card-text>
        <v-card-text v-else>
          <h2>price: {{ product.price }}₴</h2>
        </v-card-text>
        <v-card-text v-if="product.count != 0">
          <h3 class="text-danger">Закінчується</h3>
        </v-card-text>
        <v-card-text v-else>
          <h3>Закінчилось</h3>
        </v-card-text>
      </v-card>
    </div>
  </div>
</template>

<script>
import ProductDelete from "components/products/ProductDelete.vue";
import ProductUpdate from "components/products/ProductUpdate.vue";
export default {
  components: {
    ProductDelete,
    ProductUpdate,
  },
  props: ["product"],
  methods: {
    watchProduct: function (id) {
      return document.location.assign("/product/" + this.product.id);
    },
  },
};
</script>

<style>
.line-through {
  text-decoration-line: line-through;
}
</style>