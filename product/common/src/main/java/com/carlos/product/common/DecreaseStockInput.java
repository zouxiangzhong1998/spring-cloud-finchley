package com.carlos.product.common;

import lombok.Data;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/7 13:03
 */
@Data
public class DecreaseStockInput {

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

}
