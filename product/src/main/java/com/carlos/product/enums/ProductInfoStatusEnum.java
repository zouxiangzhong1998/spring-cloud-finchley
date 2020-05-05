package com.carlos.product.enums;

import lombok.Getter;

/**
 * 商品状态
 *
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/5 16:28
 */
@Getter
public enum ProductInfoStatusEnum {

    UP(0, "在架"), DOWN(1, "下架");

    private Integer code;

    private String message;

    ProductInfoStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
