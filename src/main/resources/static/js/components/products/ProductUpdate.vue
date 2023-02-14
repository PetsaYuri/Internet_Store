<template>
  <div>
    <input type="text" v-model="title" />
    <input type="submit" @click="update" value="Update" />
  </div>
</template>

<script>
import http from "http-common.js";
export default {
  props: ["product"],
  data: function () {
    return {
      title: "",
      description: "",
      count: 0,
      price: 0,
    };
  },
  methods: {
    update: function () {
      var product = {
        title: this.title,
        description: this.description,
        count: this.count,
        price: this.price,
      };
      http
        .put("/store" + this.product.id, product)
        .then((result) => result.json)
        .then((data) => (this.title = ""));
      document.location.reload(true);
    },
  },
};
</script>

<style>
</style>