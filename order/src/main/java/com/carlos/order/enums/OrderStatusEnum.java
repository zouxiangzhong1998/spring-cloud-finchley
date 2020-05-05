package com.carlos.order.enums;

import lombok.Getter;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/5 16:11
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "取消");
    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
