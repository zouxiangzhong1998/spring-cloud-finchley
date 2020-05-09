package com.carlos.user.enums;

import lombok.Getter;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/9 19:05
 */
@Getter
public enum RoleEnum {

    BUYER(1, "买家"), SELLER(2, "卖家");

    private Integer code;

    private String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
