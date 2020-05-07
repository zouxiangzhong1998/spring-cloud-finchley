package com.carlos.product.service;

import com.carlos.product.common.DecreaseStockInput;
import com.carlos.product.common.ProductInfoOutput;
import com.carlos.product.pojo.ProductInfo;

import java.util.List;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/5 16:24
 */
public interface ProductInfoService {

    /**
     * 查询所有在家商品列表
     * @return ProductInfo数据
     */
    List<ProductInfo> findUpAll();

    /**
     * 根据list ID 查询数据
     * @param productIdList ids
     * @return ProductInfo数据
     */
    List<ProductInfoOutput> findListByProductIdList(List<String> productIdList);

    /**
     * 扣库存
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);

}
