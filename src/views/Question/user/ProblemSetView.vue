<script setup lang="ts">
import {
  Question,
  QuestionControllerService,
  QuestionVO,
} from "../../../../generated";
import { onMounted, ref } from "vue";
import { useRouter } from "vue-router";

/**
 * 用于控制题目跳转
 */
const router = useRouter();

const columns = [
  {
    title: "题目",
    dataIndex: "title",
    key: "title",
  },
  {
    title: "提交数",
    dataIndex: "submitnum",
    key: "submitnum",
  },
  {
    title: "标签",
    dataIndex: "tags",
    key: "tags",
  },
];

const data = ref<QuestionVO[]>();
const total = ref(100);
const current = ref(1);
const pageSize = ref(10);
const isLoading = ref(true);

async function fetchData() {
  try {
    // 使用 await 等待异步请求完成，并获取结果
    const QuestionSetByPageSize =
      await QuestionControllerService.listQuestionVoByPageUsingPost({
        current: current.value,
        pageSize: pageSize.value,
      });

    // 获取 data 中的 records
    total.value = Number(QuestionSetByPageSize.data.total);
    current.value = Number(QuestionSetByPageSize.data.current);
    data.value = QuestionSetByPageSize.data.records;

    console.log(total.value, current.value, pageSize.value);
    isLoading.value = false;
    // 在这里执行其他需要 data 的操作
  } catch (error) {
    console.error("Error fetching data:", error);
  }
}

/**
 *控制切页
 */
const handlePageChange = (page: number) => {
  current.value = page;
  fetchData();
};

/**
 * 页面加载时获取数据

 */
onMounted(() => {
  fetchData();
});
</script>

<template>
  <div class="view problemsetview">
    <h2 class="viewtitle">题目列表</h2>
    <a-table
      :pagination="{
        total: total,
        current: current,
        pageSize: pageSize,
        showTotal: true,
        change: handlePageChange(page),
      }"
      :stripe="true"
      :data="data"
      style="margin-top: 30px"
    >
      <template #columns>
        <a-table-column title="题目" data-index="title">
          <template #cell="{ record }">
            <a :href="`/question/${record.id}`">{{ record.title }} </a>
          </template>
        </a-table-column>
        <a-table-column title="提交数" data-index="submitnum"></a-table-column>
        <a-table-column title="标签" data-index="tags"></a-table-column>
      </template>
    </a-table>
  </div>
</template>

<style scoped></style>
