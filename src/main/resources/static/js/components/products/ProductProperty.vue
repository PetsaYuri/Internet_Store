<template>
  <!-- <v-card-text>{{ this.firs }} : {{ this.sec }}</v-card-text> -->
  <v-card-text
    >{{ key }}: {{ value }}
    <div v-if="lte.length > 0">
      <h1 class="ml-300" v-for="ap in lte" :key="ap.id" :ap="ap">{{ ap }}</h1>
    </div>
  </v-card-text>
</template>

<script>
export default {
  props: ["property"],
  data: function () {
    return {
      key: null,
      value: null,
      lte: null,
    };
  },
  created: function () {
    var terr = this.property.split(":");
    this.key = terr[0];
    this.value = terr[1];
    var lte = this.value.split(",");
    this.value = lte.shift();
    this.lte = lte;
  },
};
</script>

<style>
.ml-300 {
  margin-left: 77px;
}
</style>