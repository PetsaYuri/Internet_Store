<template>
  <v-layout>
    <v-app-bar color="grey-lighten-2">
      <v-app-bar-nav-icon @click="mod = !mod"></v-app-bar-nav-icon>
      <v-app-bar-title
        ><a class="text-dark txt-decor" href="/" @click="delay"
          >Internet Store</a
        ></v-app-bar-title
      >
    </v-app-bar>

    <v-navigation-drawer
      v-model="mod"
      bottom
      temporary
      color="grey-darken-2"
      permanent
    >
      <v-list>
        <categories-list></categories-list>
      </v-list>
    </v-navigation-drawer>

    <v-main>
      <v-container>
        <router-view />
      </v-container>
    </v-main>
    <header><h1>Header</h1></header>
    <main>Main</main>
    <footer></footer>
  </v-layout>
</template>

<script>
function timer() {
  setTimeout(delay, 10000, 2);
}

function delay() {
  console.log("333333333");
}

import CategoriesList from "./CategoriesList.vue";
export default {
  components: {
    CategoriesList,
  },
  data: function () {
    return {
      mod: true,
    };
  },
  methods: {
    openCategories: function () {},

    delay: function () {
      timer();
    },

    opn: function () {},
  },
};
</script>

<style>
.txt-decor {
  text-decoration: none;
}
</style>