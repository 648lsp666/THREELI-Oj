<template>
  <div class="home">
    <!--    <MdEditor :value="value" :handle-change="handleChange" />-->
    <CodeEditor :value="value" :handle-change="handleChange" />
  </div>
</template>

<script setup lang="ts">
import MdEditor from "@/components/MdEditor.vue";
import CodeEditor from "@/components/CodeEditor.vue";
import { ref } from "vue";

const value = ref();
const handleChange = (v: string) => {
  value.value = v;
};
</script>

<style scoped></style>
