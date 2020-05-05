package com.carlos.product.repository;

import com.carlos.product.pojo.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/5 15:50
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    /**
     * 查询所有在架的商品 根据状态
     * @param productStatus 商品状态,0正常1下架
     * @return 商品数据
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);

    /**
     * 根据列表ID查询数据
     * @param productIdList 列表ID
     * @return ProductInfo 数据
     */
    List<ProductInfo> findByProductIdIn(List<String> productIdList);

}
