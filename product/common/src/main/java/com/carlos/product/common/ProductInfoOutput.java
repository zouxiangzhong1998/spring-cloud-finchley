package com.carlos.product.common;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/7 12:55
 */
@Data
public class ProductInfoOutput {

    /**
     * 主键ID
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品单价
     */
    private BigDecimal productPrice;

    /**
     * 商品库存
     */
    private Integer productStock;

    /**
     * 商品描述
     */
    private String productDescription;

    /**
     * 商品图标
     */
    private String productIcon;

    /**
     * 商品状态
     */
    private Integer productStatus;

    /**
     * 商品类目编号
     */
    private Integer categoryType;

}
