package com.yupi.threelioj.model.dto.file;

import java.io.Serializable;

import lombok.Data;

/**
 * 文件上传请求
 *
 * @author <a href="https://github.com/648lsp666">三里</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@Data
public class UploadFileRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 业务
     */
    private String biz;
}