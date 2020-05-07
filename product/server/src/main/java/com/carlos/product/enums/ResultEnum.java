package com.carlos.product.enums;

import lombok.Getter;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/7 11:24
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(1, "商品不存在"),
    PRODUCT_STOCK_ERROR(2, "库存有误"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
