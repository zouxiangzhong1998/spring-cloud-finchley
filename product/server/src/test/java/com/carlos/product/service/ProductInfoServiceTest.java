package com.carlos.product.service;

import com.carlos.product.ProductApplicationTests;
import com.carlos.product.common.DecreaseStockInput;
import com.carlos.product.pojo.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/5 16:31
 */
public class ProductInfoServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductInfoService productInfoService;

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productInfoService.findUpAll();
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void decreaseStock(){
        productInfoService.decreaseStock(Arrays.asList(new DecreaseStockInput("157875196366160022",2)));
    }
}