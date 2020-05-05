package com.carlos.product.service.impl;

import com.carlos.product.enums.ProductInfoStatusEnum;
import com.carlos.product.pojo.ProductInfo;
import com.carlos.product.repository.ProductCategoryRepository;
import com.carlos.product.repository.ProductInfoRepository;
import com.carlos.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/5 16:26
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductInfoStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findListByProductIdList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }
}
