<template>
  <div>
    <input type="text" v-model="title" />
    <input type="text" v-model="description" />
    <input type="number" v-model="count" />
    <input type="number" v-model="price" />
    <input type="submit" @click="save" value="Send" />
  </div>
</template>

<script>
import http from "http-common.js";
export default {
  props: ["products"],
  data: function () {
    return {
      title: "",
      description: "",
      count: 0,
      price: 0,
    };
  },
  methods: {
    save: function () {
      var product = {
        title: this.title,
        description: this.description,
        count: this.count,
        price: this.price,
      };
      http.post("/store", product).then((data) => {
        this.products.push(data);
        this.title = "";
        this.description = "";
        this.count = 0;
        this.price = 0;
        document.location.reload(true);
      });
    },
  },
};
</script>

<style>
</style>