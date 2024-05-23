<template>
  <div class="login-view">
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
        <a-form-item field="password" tooltip="确认密码" label="确认密码">
          <a-input-password
            v-model="form.checkPassword"
            placeholder="请确认密码"
          />
        </a-form-item>
        <a-form-item>
          <a-button html-type="submit" class="login-btn" type="primary" long
            >注册
          </a-button>
        </a-form-item>
        <a-form-item>
          <a-button type="text" @click="() => router.push('/user/login')" long
            >已有账号？ 登录
          </a-button>
        </a-form-item>
      </a-form>
    </div>
  </div>
</template>

<style scoped></style>
<script setup lang="ts">
import router from "@/router";
import { reactive } from "vue";
import { UserControllerService } from "../../../generated";
import message from "@arco-design/web-vue/es/message";

const form = reactive({
  userAccount: "",
  userPassword: "",
  checkPassword: "",
});

/**
 * 提交注册表单
 */
const handleSubmit = async () => {
  const res = await UserControllerService.userRegisterUsingPost(form);
  if (res.code === 0) {
    //todo 注册成功
    message.success("注册成功!即将跳转到登录页……");

    setTimeout(() => {
      router.push("/user/login");
    }, 2000);
  } else {
    message.error("注册失败:", res.message);
  }
};
</script>
