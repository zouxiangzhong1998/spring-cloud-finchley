package com.carlos.product.service;

import com.carlos.product.ProductApplicationTests;
import com.carlos.product.pojo.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

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
}