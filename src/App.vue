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

.bytemd-toolbar-icon.bytemd-tippy.bytemd-tippy-right:last-child {
  display: none;
}

.viewtitle {
  padding: 15px 0;
}

.view {
  width: 100%;
  padding: 0 30px 30px 30px;
}

a {
  all: unset;
  cursor: pointer;

  &:hover {
    color: #509be3;
  }
}
</style>
<script setup lang="ts">
// todo 项目扩展 用diff模块展现用户代码和标准代码的区别
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
