package com.carlos.product.service;

import com.carlos.product.pojo.ProductCategory;

import java.util.List;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/5 16:34
 */
public interface ProductCategoryService {

    /**
     * 获取类目type列表
     * @param categoryTypeList 类型
     * @return 类目数据
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
