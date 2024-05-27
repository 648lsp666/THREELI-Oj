<template>
  <div id="questionlayout">
    <a-layout-footer class="footer">
      Written by
      <a href="https://github.com/648lsp666" target="_blank" class="herf">
        ThreeLi
      </a>
    </a-layout-footer>
  </div>
</template>

<style scoped>
#questionlayout {
}

#questionlayout .header {
  display: flex;
  justify-content: center;
  align-items: center;
  flex: 0.5;
}

#questionlayout .logo {
  box-shadow: #0000331f 3px 5px 2px;
  border-radius: 50%;
  height: 64px;
  cursor: pointer;
}

#questionlayout .content {
  display: flex;
  justify-content: center;
  border-radius: 15px;
  height: auto;
}

#questionlayout .footer {
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
