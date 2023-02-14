<template>
  <div>
    <v-list-item-title class="text-center"> Categories </v-list-item-title>
    <category
      v-for="category in categories"
      :key="category.id"
      :category="category"
    />
    <v-list-item>
      <v-btn width="300" @click="clearFilters">Clear Filters</v-btn>
    </v-list-item>
  </div>
</template>

<script>
import http from "http-common.js";
import Category from "../components/categories/Category.vue";
export default {
  components: {
    Category,
  },
  data: function () {
    return {
      categories: null,
    };
  },
  methods: {
    clearFilters: function () {
      var locat = document.location.href;
      var arr = locat.split("?");
      return document.location.assign(arr[0]);
    },
  },
  created: function () {
    http.get("/categories/").then((res) => (this.categories = res.data));
  },
};
</script>

<style>
</style>