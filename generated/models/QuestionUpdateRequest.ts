/* generated using openapi-typescript-codegen -- do not edit */
/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { JudgeCase } from './JudgeCase';
import type { JudgeConfig } from './JudgeConfig';
export type QuestionUpdateRequest = {
    answer?: string;
    content?: string;
    id?: number;
    judgeCaseList?: Array<JudgeCase>;
    judgeconfig?: JudgeConfig;
    tags?: Array<string>;
    title?: string;
};

