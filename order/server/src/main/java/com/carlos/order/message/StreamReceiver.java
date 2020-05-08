package com.carlos.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/8 18:34
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    @StreamListener(StreamClient.OUTPUT)
    public void processOutput(Object message) {
        log.info("StreamReceiver OUTPUT : {}", message);
    }

}
