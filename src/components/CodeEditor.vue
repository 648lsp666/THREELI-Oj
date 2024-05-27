<template>
  <div id="code-editor" ref="codeEditorRef"></div>
</template>

<style scoped>
#code-editor {
  min-height: 400px;
  height: 100%;
}
</style>

<script setup lang="ts">
import * as monaco from "monaco-editor";
import { defineProps, onMounted, ref, toRaw, withDefaults } from "vue";

const codeEditorRef = ref();
const codeEditor = ref();

/**
 * 代码编辑器接口和类型
 * @interface CodeEditor
 * 用于传递值给父组件
 */
interface CodeEditor {
  value: string;
  handleChange: (value: string) => void;
}

const props = defineProps<CodeEditor>();

onMounted(() => {
  console.log(codeEditor.value);
  if (!codeEditorRef.value) {
    return;
  }
  codeEditor.value = monaco.editor.create(codeEditorRef.value, {
    value: props.value,
    language: "javascript",
    lineNumbers: "off",
    roundedSelection: false,
    scrollBeyondLastLine: false,
    readOnly: false,
    theme: "vs-light",
  });

  codeEditor.value.onDidChangeModelContent(() => {
    props.handleChange(toRaw(codeEditor.value).getValue());
  });
});
</script>
