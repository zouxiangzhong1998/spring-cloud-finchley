package com.carlos.product.service;

import com.carlos.product.ProductApplicationTests;
import com.carlos.product.pojo.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/5 16:36
 */
public class ProductCategoryServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> list = productCategoryService.findByCategoryTypeIn(Arrays.asList(1, 2));
        Assert.assertTrue(list.size() > 0);
    }
}