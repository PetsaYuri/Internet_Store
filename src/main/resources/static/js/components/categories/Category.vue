<template>
  <div v-if="this.currentCategory == category.title">
    <v-list-item active="true" active-color="blue">
      <v-btn width="300" @click="activeCategory(category.title)">{{
        category.title
      }}</v-btn>
    </v-list-item>
  </div>

  <div v-else>
    <v-list-item active-color="black">
      <v-btn width="300" @click="activeCategory(category.title)">{{
        category.title
      }}</v-btn>
    </v-list-item>
  </div>
</template>

<script>
export default {
  props: ["category"],
  data: function () {
    return {
      currentCategory: null,
    };
  },
  methods: {
    activeCategory: function (title) {
      return document.location.assign("/?category=" + title);
    },
  },
  created: function () {
    var locat = document.location.href;
    var arr = locat.split("category=");
    this.currentCategory = arr[1];
  },
};
</script>
<style>
</style>