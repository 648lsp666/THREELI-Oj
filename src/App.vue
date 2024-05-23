<template>
  <div id="app">
    <template v-if="route.path.startsWith('/user')">
      <UserLayout />
    </template>
    <template v-else>
      <BasicLayout />
    </template>
  </div>
</template>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
</style>
<script setup lang="ts">
import BasicLayout from "../layouts/BasicLayout.vue";
import { onMounted } from "vue";
import { useRoute } from "vue-router";
import UserLayout from "../layouts/UserLayout.vue";

const route = useRoute();
/**
 * 全局初始化代码
 */
const doInit = () => {
  console.log("欢迎！");
};

onMounted(() => {
  doInit();
});
</script>
