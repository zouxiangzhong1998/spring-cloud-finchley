package com.carlos.order.controller;

import com.carlos.product.client.ProductClient;
import com.carlos.product.common.DecreaseStockInput;
import com.carlos.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/5 18:42
 */
@RestController
@Slf4j
public class ClientController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getListForOrder")
    public String listForOrder() {
        List<ProductInfoOutput> productInfos = productClient.listForOrder(Arrays.asList("157875196366160022", "157875227953464068"));
        log.info("productInfos = {}", productInfos);
        return "ok";
    }

    @GetMapping("/productDecreaseStock")
    public String productDecreaseStock() {
        productClient.decreaseStock(Arrays.asList(new DecreaseStockInput("164103465734242707", 3)));
        return "ok";
    }

}
