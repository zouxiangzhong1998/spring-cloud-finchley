package com.carlos.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收 MQ 消息
 *
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/8 17:58
 */
@Component
@Slf4j
public class MqReceiver {

    /**
     * 1. @RabbitListener(queues = "myQueue") 监听队列，但是不创建队列，需要手动创建
     * 2. @RabbitListener(queuesToDeclare = @Queue("myQueue")) 自动创建队列
     * 3. @RabbitListener(bindings = @QueueBinding(value = @Queue("myQueue"), exchange = @Exchange("myExchange"))) 自动创建队列，Exchange 和 Queue 绑定
     *
     * @param message 消息
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String message) {
        log.info("MqReceiver: {}", message);
    }

    /**
     * 数码供应商服务 接收消息
     *
     * @param message 消息
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "digital",
            value = @Queue("digitalOrder")

    ))
    public void processDigital(String message) {
        log.info("digital MqReceiver: {}", message);
    }

    /**
     * 水果供应商服务 接收消息
     *
     * @param message 消息
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "fruit",
            value = @Queue("fruitOrder")

    ))
    public void processFruit(String message) {
        log.info("fruit MqReceiver: {}", message);
    }

}
