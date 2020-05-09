package com.carlos.order.message;

import com.carlos.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * 消费端
 *
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/8 18:34
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    /**
     * 接收 orderDTO 对象消息
     *
     * @param message
     */
    @StreamListener(value = StreamClient.OUTPUT)
    @SendTo(value = StreamClient.OUTPUT2)
    public String processOutput(OrderDTO message) {
        log.info("StreamReceiver : {}", message);
        return "received.";
    }

    @StreamListener(value = StreamClient.OUTPUT2)
    public void processOutput2(String message) {
        log.info("StreamReceiver2 : {}", message);
    }

}
