<template>
  <div id="userLayout">
    <a-layout style="height: 100vh">
      <a-layout-header class="header">
        <img class="logo" src="@/assets/logo.png" alt="logo" />
        <div class="title">
          <a-typography-title
            :level="2"
            style="margin: 15px; color: #000"
            class="title"
          >
            3l's OJ
          </a-typography-title>
        </div>
      </a-layout-header>
      <a-layout-content class="content">
        <router-view />
      </a-layout-content>
    </a-layout>
    <a-layout-footer class="footer">
      Written by
      <a href="https://github.com/648lsp666" target="_blank" class="herf">
        ThreeLi
      </a>
    </a-layout-footer>
  </div>
</template>

<style scoped>
#userLayout {
}
#userLayout .header {
  display: flex;
  justify-content: center;
  align-items: center;
  flex: 0.5;
}
#userLayout .logo {
  box-shadow: #0000331f 3px 5px 2px;
  border-radius: 50%;
  height: 64px;
  cursor: pointer;
}
#userLayout .content {
  display: flex;
  justify-content: center;
  border-radius: 15px;
  height: auto;
}
#userLayout .footer {
  background: linear-gradient(to bottom, transparent, aliceblue);
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  text-align: center;
  padding: 12px;
}
</style>
<script setup lang="ts"></script>
