package com.carlos.order;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 发送mq消息测试
 *
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/8 18:02
 */
public class MqSenderTest extends OrderApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send() {
        amqpTemplate.convertAndSend("myQueue", "now " + new Date());
    }

    @Test
    public void sendOrder() {
        amqpTemplate.convertAndSend("myOrder", "digital", "now " + new Date());
    }

}
