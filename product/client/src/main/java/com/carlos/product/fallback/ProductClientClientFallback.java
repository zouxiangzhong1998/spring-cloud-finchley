package com.carlos.product.fallback;

import com.carlos.product.client.ProductClient;
import com.carlos.product.common.DecreaseStockInput;
import com.carlos.product.common.ProductInfoOutput;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/10 15:32
 */
@Component
public class ProductClientClientFallback implements ProductClient {


    @Override
    public List<ProductInfoOutput> listForOrder(List<String> productIdList) {
        return null;
    }

    @Override
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {

    }
}
