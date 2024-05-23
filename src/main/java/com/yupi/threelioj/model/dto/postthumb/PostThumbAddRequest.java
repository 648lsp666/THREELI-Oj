package com.yupi.threelioj.model.dto.postthumb;

import java.io.Serializable;

import lombok.Data;

/**
 * 帖子点赞请求
 *
 * @author <a href="https://github.com/648lsp666">三里</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@Data
public class PostThumbAddRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 帖子 id
     */
    private Long postId;
}