package com.yupi.threelioj.model.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 题目
 */
@Getter
@Setter
public class Question {
    /**
     * id
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签列表（json 数组）
     */
    private String tags;

    /**
     * 题目答案
     */
    private String answer;

    /**
     * 提交数
     */
    private Integer submitnum;

    /**
     * 通过数
     */
    private Integer acceptednum;

    /**
     * 判题配置(json)
     */
    private String judgeconfig;

    /**
     * 判题用例数组（json 数组）
     */
    private String judgecase;

    /**
     * 点赞数
     */
    private Integer thumbnum;

    /**
     * 收藏数
     */
    private Integer favournum;

    /**
     * 创建用户 id
     */
    private Long userid;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 是否删除
     */
    private Byte isdelete;
}