<template>
  <div>
    <input type="submit" @click="remove" value="Delete" />
  </div>
</template>

<script>
import http from "http-common.js";
export default {
  props: ["product"],
  methods: {
    remove: function () {
      http.delete("/store" + this.product.id).then((result) => result.json);
      document.location.reload(true);
    },
  },
};
</script>

<style>
</style>