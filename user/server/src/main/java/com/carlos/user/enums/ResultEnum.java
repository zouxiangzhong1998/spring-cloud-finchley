package com.carlos.user.enums;

import lombok.Getter;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/5 16:11
 */
@Getter
public enum ResultEnum {
    LOGIN_FAIL(1,"登录失败"),
    ROLE_ERROR(2,"角色权限有误"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
