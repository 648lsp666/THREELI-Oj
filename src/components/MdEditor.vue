<template>
  <Editor :value="value" :plugins="plugins" @change="handleChange" />
</template>

<style scoped></style>
<script setup lang="ts">
import gfm from "@bytemd/plugin-gfm";
import hightlight from "@bytemd/plugin-highlight";
import { Editor, Viewer } from "@bytemd/vue-next";
import { defineProps } from "vue";

const plugins = [
  gfm(),
  hightlight(),
  // Add more plugins here
];

interface MdEditor {
  value: string;
  handleChange: (value: string) => void;
}

const props = defineProps<MdEditor>();
</script>
