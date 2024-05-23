package com.yupi.threelioj.model.dto.post;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 创建请求
 *
 * @author <a href="https://github.com/648lsp666">三里</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@Data
public class PostAddRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 标签列表
     */
    private List<String> tags;
}