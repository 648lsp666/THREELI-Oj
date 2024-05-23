package com.yupi.threelioj.model.dto.user;

import java.io.Serializable;

import lombok.Data;

/**
 * 用户注册请求体
 *
 * @author <a href="https://github.com/648lsp666">三里</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;
}
