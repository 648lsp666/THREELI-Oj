package com.yupi.threelioj.model.dto.question;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 编辑请求
 *
 * @author <a href="https://github.com/648lsp666">三里</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@Data
public class QuestionEditRequest implements Serializable {

    private static final long serialVersionUID = 1L;
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
    private List<String> tags;
    /**
     * 题目答案
     */
    private String answer;
    /**
     * 判题配置(json)
     */
    private String judgeconfig;
    /**
     * todo 判题用例数组（json 数组）
     */
    private String judgecase;
}