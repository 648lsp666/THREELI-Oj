<script setup lang="ts">
import { useRouter } from "vue-router";
import { ref } from "vue";
import { QuestionControllerService, QuestionVO } from "../../../../generated";

const router = useRouter();
const QuestionId: any = Number(router.currentRoute.value.params.id);
const QuestionProfile = ref<QuestionVO>();
const fetchData = async () => {
  try {
    const QuestionProfileById =
      await QuestionControllerService.getQuestionVoByIdUsingGet(QuestionId);
    QuestionProfile.value = QuestionProfileById.data;
  } catch (error) {
    console.error("Error fetching data:", error);
  }
};
</script>

<template></template>

<style scoped></style>
