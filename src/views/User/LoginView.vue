<template>
  <div class="login-view">
    <a-form
      :model="form"
      :style="{ width: '500px' }"
      @submit="handleSubmit"
      label-align="left"
      auto-label-width
    >
      <a-form-item field="userName" label="用户名">
        <a-input v-model="form.userAccount" placeholder="请输入用户名" />
      </a-form-item>
      <a-form-item field="password" tooltip="密码不少于8位" label="密码">
        <a-input-password
          v-model="form.userPassword"
          placeholder="请输入密码"
        />
      </a-form-item>
      <a-form-item>
        <a-button html-type="submit" class="login-btn" type="primary" long
          >登录
        </a-button>
      </a-form-item>
      <a-form-item>
        <a-button type="text" @click="() => router.push('/user/register')" long
          >还没有账号？ 注册
        </a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<style scoped>
.login-btn {
  padding: 10px 0;
  margin-top: 16px;
}
</style>
<script setup lang="ts">
import { reactive } from "vue";
import { UserControllerService, UserLoginRequest } from "../../../generated";
import message from "@arco-design/web-vue/es/message";
import router from "@/router";
import store from "@/store";

/**
 * 表单数据
 */
const form = reactive({
  userAccount: "",
  userPassword: "",
} as UserLoginRequest);
/**
 * 提交表单
 * @param
 */
const handleSubmit = async () => {
  const res = await UserControllerService.userLoginUsingPost(form);
  if (res.code === 0) {
    //todo 登录成功
    message.success("This is a success message!");
    await store.dispatch("user/getLoginUser");
    router.push({
      path: (router.currentRoute.value.query.redirect as string) || "/",
      replace: true,
    });
  } else {
    //todo 登录失败
    message.error("登录失败！" + res.message);
  }
};
</script>
