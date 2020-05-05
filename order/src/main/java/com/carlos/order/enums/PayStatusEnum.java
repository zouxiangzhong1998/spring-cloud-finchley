package com.carlos.order.enums;

import lombok.Getter;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/5 16:11
 */
@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功");
    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
