package com.carlos.product.client;

import com.carlos.product.common.DecreaseStockInput;
import com.carlos.product.common.ProductInfoOutput;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/7 13:12
 */
@FeignClient(name = "product")
public interface ProductClient {

    /**
     * 获取商品列表（给订单服务用的）
     *
     * @param productIdList ids
     * @return
     */
    @PostMapping("/product/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

    /**
     * 扣库存
     *
     * @param decreaseStockInputList
     */
    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);

}
