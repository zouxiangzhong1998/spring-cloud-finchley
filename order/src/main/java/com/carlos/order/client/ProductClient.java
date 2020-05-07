package com.carlos.order.client;

import com.carlos.order.dto.CartDTO;
import com.carlos.order.pojo.ProductInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/5 19:36
 */
@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/msg")
    String msg();

    /**
     * 获取商品列表（给订单服务用的）
     * @param productIdList ids
     * @return
     */
    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> productIdList);

    /**
     * 扣库存
     * @param cartDTOList
     */
    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOList);

}
