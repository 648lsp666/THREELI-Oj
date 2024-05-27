<script setup lang="ts">
import { onMounted, ref } from "vue";
import MdEditor from "@/components/MdEditor.vue";
import CodeEditor from "@/components/CodeEditor.vue";
import { useRoute } from "vue-router";
import { QuestionControllerService } from "../../../../generated";
import message from "@arco-design/web-vue/es/message";
import { deepCopy } from "@/utils/deepCopy";
import router from "@/router";

const questionId = useRoute().params.id as number;

const form = ref({
  answer: "",
  content: "",
  judgeCaseList: [{}],
  judgeconfig: {},
  tags: [],
  title: "",
});

onMounted(async () => {
  const res = await QuestionControllerService.getQuestionByIdUsingGet(
    questionId
  );
  if (res.code !== 0) {
    message.error(res.message);
    router.push("/question/manage");
    return;
  }
  form.value = {
    id: questionId,
    answer: res.data.answer || "",
    content: res.data.content,
    judgeCaseList: JSON.parse(res.data.judgecase) || [
      { input: "", output: "" },
    ],
    judgeconfig: JSON.parse(res.data.judgeconfig),
    tags: JSON.parse(res.data.tags),
    title: res.data.title,
  };
});

const handleContentChange = (content: string) => {
  form.value.content = content;
};
const handleAnswerChange = (answer: string) => {
  form.value.answer = answer;
};
const handleAddJudgeCase = () => {
  form.value.judgeCaseList.push({
    input: "",
    output: "",
  });
};
const handleSubmit = async () => {
  const res = await QuestionControllerService.updateQuestionUsingPost(
    form.value
  );
  if (res.code === 0) {
    message.success("更新成功！");
  } else {
    message.error("更新失败！");
  }
};
</script>

<template>
  <div class="view add-question-view">
    <h2 class="viewtitle">修改题目</h2>
    <a-form
      :model="form"
      :style="{ width: '100%' }"
      @submit="handleSubmit"
      auto-label-width
      label-align="left"
      layout="vertical"
    >
      <a-form-item field="title" label="标题">
        <a-input v-model="form.title" placeholder="请输入标题" />
      </a-form-item>
      <a-form-item field="multiSelect" label="标签">
        <a-select
          multiple
          v-model="form.tags"
          placeholder="请输入标签"
          allow-create
        >
          <a-option value="简单">简单</a-option>
          <a-option value="中等">中等</a-option>
          <a-option value="困难">困难</a-option>
        </a-select>
      </a-form-item>
      <a-form-item field="content" label="内容">
        <MdEditor
          :style="{
            height: '300px',
            width: '100%',
          }"
          :value="form.content"
          :handle-change="handleContentChange"
        />
      </a-form-item>
      <a-form-item field="answer" label="答案">
        <MdEditor
          :style="{
            height: '300px',
            width: '100%',
          }"
          :value="form.answer"
          :handle-change="handleAnswerChange"
        />
      </a-form-item>
      <div class="addjudgecase">
        <a-button type="primary" @click="handleAddJudgeCase"
          >添加测试用例
        </a-button>
      </div>
      <a-form-item
        v-for="(judgeCase, index) of form.judgeCaseList"
        field="judgeCaseList"
        :label="`测试用例 - ${index + 1}`"
        :key="index"
      >
        <a-space class="judgecase" fill>
          <div class="delete">
            <a-button
              @click="
                () => {
                  if (form.judgeCaseList.length === 1) {
                    message.error('至少保留一个测试用例');
                    return;
                  }
                  form.judgeCaseList.splice(index, 1);
                }
              "
              class="deletebtn"
            >
              ×
            </a-button>
          </div>
          <label class="label">
            输入
            <a-input
              v-model="judgeCase.input"
              :placeholder="`请输入样例输入${index + 1}`"
            />
          </label>
          <label class="label">
            输出
            <a-input
              v-model="judgeCase.output"
              :placeholder="`请输入样例输入${index + 1}`"
            />
          </label>
        </a-space>
      </a-form-item>
      <a-form-item field="judgeconfig" label="评测配置">
        <a-space direction="vertical" fill>
          <a-form-item field="timeLimit" label="时间限制/ms">
            <a-input-number
              mode="button"
              v-model="form.judgeconfig.timeLimit"
            />
          </a-form-item>
          <a-form-item field="memoryLimit" label="内存限制/kb">
            <a-input-number
              mode="button"
              v-model="form.judgeconfig.memoryLimit"
            />
          </a-form-item>
          <a-form-item field="stackLimit" label="栈限制/kb">
            <a-input-number
              mode="button"
              v-model="form.judgeconfig.stackLimit"
            />
          </a-form-item>
        </a-space>
      </a-form-item>
      <a-form-item>
        <a-button type="primary" @click="handleSubmit">提交修改</a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<style scoped>
.judgecase {
  border-radius: 20px;
  padding: 16px 5px;
  position: relative;

  &:hover {
    background-color: #f0f0f0;

    & .deletebtn {
      display: flex;
    }
  }
}

.label {
  display: flex;
  align-items: center;
  justify-content: center;

  & > span {
    margin-left: 16px;
    flex: 1;
  }
}

.delete {
  position: absolute;
  top: 0;
  right: 0;

  & .deletebtn {
    border-radius: 100%;
    transform: translate(50%, -50%);
    padding: 3px;
    height: 18px;
    display: none;
  }
}

.addjudgecase {
  padding: 10px 10px 10px 10px;
}
</style>
