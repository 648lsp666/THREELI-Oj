<template>
  <a-row
    class="menubar"
    style="margin-bottom: 16px"
    align="center"
    :wrap="false"
  >
    <a-col flex="auto">
      <div>
        <a-menu
          mode="horizontal"
          :selected-keys="currentRoute"
          @menu-item-click="handleMenuClick"
          :collapsed="false"
          :style="{ minWidth: 380 + 'px' }"
        >
          <a-menu-item
            key="0"
            :style="{ padding: 0, marginRight: '38px' }"
            disabled
          >
            <div class="logo-content">
              <img
                src="../assets/logo.png"
                alt="logo"
                class="logo"
                :style="{ width: 120 + 'px' }"
              />
            </div>
          </a-menu-item>
          <a-menu-item v-for="route in routes" :key="route.path"
            >{{ route.name }}
          </a-menu-item>
        </a-menu>
      </div>
    </a-col>
    <a-col flex="200px">
      <div>
        <div class="userprofile">
          <a-avatar src="" style="margin-right: 8px" />
          {{ state.user?.loginUser?.userName ?? "ThreeLi" }}
          <a-icon type="down" />
        </div>
      </div>
    </a-col>
  </a-row>
</template>

<style scoped>
.menubar {
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.15);
}

.logo {
  box-shadow: #0000331f 3px 5px 2px;
  border-radius: 50%;
  cursor: pointer;
}

.userprofile {
  margin-right: 16px;
  cursor: pointer;
}
</style>

<script setup lang="ts">
import router from "@/router";
import { computed, ref } from "vue";
import { useStore } from "vuex";
import checkAccess from "@/access/checkAccess";
import ACCESS_ENUM from "@/access/accessEnum";

/**
 * 路由控制模块
 */
const store = useStore();
const { state } = store;

const routes = computed(() => {
  return router.getRoutes().filter((item) => {
    if (item.meta?.hideInMenu) {
      return false;
    }
    if (checkAccess(state.user?.loginUser, item.meta?.access as string)) {
      return true;
    }
    return false;
  });
});
console.log(routes);
const currentRoute = ref(["/"]);

// setTimeout(() => {
//   store.dispatch("user/getLoginUser", {
//     userName: "threeli",
//     userRole: ACCESS_ENUM.ADMIN,
//   });
// }, 3000);

// 路由监听
router.afterEach((to, from, failure) => {
  currentRoute.value = [to.path];
});
// 菜单点击事件
const handleMenuClick = (key: string) => {
  router.push({
    path: key,
  });
};
</script>
