/* generated using openapi-typescript-codegen -- do not edit */
/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { JudgeCase } from './JudgeCase';
import type { JudgeConfig } from './JudgeConfig';
export type QuestionAddRequest = {
    answer?: string;
    content?: string;
    judgeCaseList?: Array<JudgeCase>;
    judgeconfig?: JudgeConfig;
    tags?: Array<string>;
    title?: string;
};

