package com.yupi.threelioj.model.dto.postfavour;

import java.io.Serializable;

import lombok.Data;

/**
 * 帖子收藏 / 取消收藏请求
 *
 * @author <a href="https://github.com/648lsp666">三里</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@Data
public class PostFavourAddRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 帖子 id
     */
    private Long postId;
}