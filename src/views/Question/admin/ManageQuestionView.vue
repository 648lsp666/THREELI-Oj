<script setup lang="ts">
import {
  Question,
  QuestionControllerService,
  QuestionVO,
} from "../../../../generated";
import { onMounted, ref } from "vue";
import { useRouter } from "vue-router";
import dayjs from "dayjs";
import message from "@arco-design/web-vue/es/message";
import { Modal } from "@arco-design/web-vue";

/**
 * 用于控制题目跳转
 */
const router = useRouter();

// {
//   "title": "A+B",
//   "content": "123",
//   "tags": [
//   "简单",
//   "暴力"
// ],
//   "judgeconfig": {
//   "timeLimit": null,
//     "memoryLimit": null,
//     "stackLimit": null
// },
//   "submitnum": 0,
//   "acceptednum": 0,
//   "thumbnum": 0,
//   "favournum": 0,
//   "userid": null,
//   "createtime": "2024-05-23T17:34:05.000+00:00",
//   "updatetime": "2024-05-23T17:34:05.000+00:00",
//   "userVO": {
//   "id": "1792943581319577602",
//     "userName": "三里",
//     "userAvatar": null,
//     "userProfile": null,
//     "userRole": "admin",
//     "createTime": "2024-05-21T15:40:35.000+00:00"
// },
//   "isDelete": 0,
//   "id": "1793696918960787457"
// },

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

    console.log(QuestionSetByPageSize.data.records);
    isLoading.value = false;

    // 在这里执行其他需要 data 的操作
  } catch (error) {
    console.error("Error fetching data:", error);
  }
}

/**
 * 删除题目
 */
const handleDelete = async (id: number) => {
  try {
    const res = await QuestionControllerService.deleteQuestionUsingPost({
      id: id,
    });
    if (res.code == 0) {
      message.success("删除成功!");
      fetchData();
    } else {
      message.error("删除失败! " + res.message);
    }
    console.log(res);
  } catch (error) {
    console.error("Error deleting data:", error);
    message.error("异常错误！");
  }
};

const questionToDelete = ref<QuestionVO>();
const visible = ref(false);
const handleCancel = () => {
  visible.value = false;
};
const handleBeforeOk = async () => {
  await handleDelete(questionToDelete.value.id as number);
  visible.value = false;
};
const showModal = (record: QuestionVO) => {
  questionToDelete.value = record;
  visible.value = true;
};
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
        simple: true,
      }"
      :stripe="true"
      :data="data"
      style="margin-top: 30px"
    >
      <template #columns>
        <a-table-column title="ID" data-index="id">
          <template #cell="{ record }">
            {{ record.id }}
          </template>
        </a-table-column>
        <a-table-column title="题目" data-index="title">
          <template #cell="{ record }">
            <a :href="`/question/${record.id}`">{{ record.title }} </a>
          </template>
        </a-table-column>
        <a-table-column
          title="创建者"
          data-index="userVO.userName"
        ></a-table-column>
        <a-table-column title="提交数" data-index="submitnum"></a-table-column>
        <a-table-column title="标签" data-index="tags"></a-table-column>
        <a-table-column title="创建时间" data-index="createtime">
          <template #cell="{ record }">
            {{ dayjs(record.createtime).format("YYYY-MM-DD HH:mm:ss") }}
          </template>
        </a-table-column>
        <a-table-column title="更新时间" data-index="updatetime">
          <template #cell="{ record }">
            {{ dayjs(record.updatetime).format("YYYY-MM-DD HH:mm:ss") }}
          </template>
        </a-table-column>
        <a-table-column title="操作" key="action">
          <template #cell="{ record }">
            <a-button
              type="text"
              @click="router.push(`/question/update/${record.id}`)"
            >
              修改
            </a-button>
            <a-button type="text" status="danger" @click="showModal(record)">
              删除
            </a-button>
            <a-modal
              v-model:visible="visible"
              @cancel="handleCancel"
              :on-before-ok="handleBeforeOk"
              unmountOnClose
            >
              <template #title> 确认删除</template>
              <div>
                <p>
                  确认删除题目: {{ record.title }} ?
                  此举将会删除题目所有的全部信息！
                </p>
              </div>
            </a-modal>
          </template>
        </a-table-column>
      </template>
    </a-table>
  </div>
</template>

<style scoped></style>
