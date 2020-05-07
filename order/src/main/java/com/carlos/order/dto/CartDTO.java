package com.carlos.order.dto;

import lombok.Data;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/7 11:15
 */
@Data
public class CartDTO {

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
