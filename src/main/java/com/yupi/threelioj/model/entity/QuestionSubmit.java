package com.yupi.threelioj.model.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 问题提交类
 */
@Getter
@Setter
public class QuestionSubmit {
    /**
     * id
     */
    private Long id;

    /**
     * 题目id
     */
    private Long questionid;

    /**
     * 提交者id
     */
    private Long userid;

    /**
     * 使用代码语言
     */
    private String language;

    /**
     * 代码内容
     */
    private String code;

    /**
     * 判题信息
     */
    private String judgeinfo;

    /**
     * 评测结果 0-未评测 1-判题中 2-通过 3-未通过
     */
    private Long status;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;
}
