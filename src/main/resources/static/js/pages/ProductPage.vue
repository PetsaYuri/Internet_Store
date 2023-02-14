<template>
  <div>
    <h1 class="text-center">
      <b>{{ product.title }}</b>
      <p>reviews</p>
    </h1>

    <v-tabs background-color="blue" v-model="tab">
      <v-tab value="allAboutProduct">All About Product</v-tab>
      <v-tab value="property" @click="prop">Property</v-tab>
      <v-tab value="reviews">Reviews</v-tab>
      <v-tab value="questions">Questions</v-tab>
    </v-tabs>

    <v-window v-model="tab">
      <v-window-item value="allAboutProduct">
        <div class="d-flex mt-5 ml-5">
          <img src="/img/LC27G55T.png" alt="" />
          <v-card class="ml-3">
            <v-card-title
              >{{ product.price }}₴
              <v-btn href="#" color="green">Buy</v-btn>
              <v-btn href="#" color="blue" class="ml-3">Buy in credit</v-btn>
            </v-card-title>
            <v-radio-group
              v-for="option in product.category.options"
              v-model="active"
              :key="option.id"
            >
              {{ options(option) }}
              <v-card-text class="ml-2">
                <v-card-text>
                  <h1 class="text-h6 text-nowrap">
                    <v-radio
                      :name="radio + key"
                      :label="option.title"
                      @click="act(option.id)"
                    ></v-radio>
                    <!--   <v-radio v-for=""></v-radio> -->
                  </h1>
                  <!--  <div
                    class="ml-5 font-weight-bold"
                    v-for="optionr in str"
                    :key="optionr.id"
                  >
                        {{ optionr }} - {{ option.price }}₴ 
                    <v-btn-toggle><v-btn>dd</v-btn></v-btn-toggle>
                  </div> -->
                </v-card-text>
              </v-card-text>
            </v-radio-group>
          </v-card>
        </div>
      </v-window-item>

      <v-window-item value="property">
        <v-card border="" class="mt-5">
          <product-property
            v-for="property in arr"
            :key="property.id"
            :property="property"
            :count="count"
            :arr="arr + 1"
          ></product-property>
        </v-card>
      </v-window-item>
      <v-window-item value="reviews">
        <p>ttttttttt</p>
      </v-window-item>
    </v-window>
  </div>
</template>
<script>
import http from "http-common.js";
import ProductProperty from "../components/products/ProductProperty.vue";
export default {
  components: {
    ProductProperty,
  },
  data: function () {
    return {
      product: null,
      tab: null,
      arr: null,
      str: null,
      opt: null,
      active: false,
      title: "title12",
    };
  },
  methods: {
    prop: function () {
      this.arr = this.product.description.split(";");
    },
    options: function (option) {
      this.str = option.description.split(";");
    },
    act: function (key) {
      console.log(key);
      this.active = !this.active;
    },
    //JSON.stringify(category.options[0].id)
  },
  created: function () {
    http
      .get("/store/" + this.$route.params.id)
      .then((res) => (this.product = res.data));
  },
};
</script>
<style>
</style>