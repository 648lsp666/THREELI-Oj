<template>
  <div id="basicLayout">
    <a-layout style="height: 400px">
      <a-layout-header class="header">
        <MenuBar></MenuBar>
      </a-layout-header>
      <a-layout-content class="content">
        <router-view />
      </a-layout-content>
      <a-layout-footer class="footer">
        Written by
        <a href="https://github.com/648lsp666" target="_blank" class="herf">
          ThreeLi
        </a>
      </a-layout-footer>
    </a-layout>
  </div>
</template>

<style scoped>
#basicLayout {
}
#basicLayout .header {
}
#basicLayout .content {
  background: #42b983;
}
#basicLayout .footer {
  background: linear-gradient(to bottom, #fffffe, aliceblue);
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  text-align: center;
  padding: 12px;
}
</style>
<script setup lang="ts">
import MenuBar from "@/components/MenuBar.vue";
</script>
