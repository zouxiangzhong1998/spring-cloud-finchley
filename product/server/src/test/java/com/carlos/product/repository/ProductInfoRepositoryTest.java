package com.carlos.product.repository;

import com.carlos.product.ProductApplicationTests;
import com.carlos.product.pojo.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;


/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/5 15:54
 */
public class ProductInfoRepositoryTest extends ProductApplicationTests {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfos = productInfoRepository.findByProductStatus(0);
        Assert.assertTrue(productInfos.size() > 0);
    }

    @Test
    public void findByProductIdIn() {
        List<ProductInfo> productInfos = productInfoRepository.findByProductIdIn(Arrays.asList("157875196366160022", "157875227953464068"));
        Assert.assertTrue(productInfos.size() > 0);
    }
}
