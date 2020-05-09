package com.carlos.order.message;

import com.carlos.product.common.ProductInfoOutput;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/9 15:11
 */
@Component
@Slf4j
public class ProductInfoReceiver {

    private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message) {
        // message = > ProductInfoOutput
        Gson gson = new Gson();
        List<ProductInfoOutput> productInfoOutputList = gson.fromJson(message,
                new TypeToken<List<ProductInfoOutput>>() {}.getType());

        log.info("从队列【{}】接收到消息：{}", "productInfo", productInfoOutputList);

        // 存储到redis中
        for (ProductInfoOutput productInfoOutput : productInfoOutputList) {
            String key = String.format(PRODUCT_STOCK_TEMPLATE, productInfoOutput.getProductId());
            stringRedisTemplate.opsForValue().set(key, String.valueOf(productInfoOutput.getProductStock()));
        }
    }

}
