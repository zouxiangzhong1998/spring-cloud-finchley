package com.carlos.order.controller;

import com.carlos.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/8 18:37
 */
@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

    @GetMapping("/sendMessage")
    public void process() {
        String message = "now " + new Date();
        streamClient.output().send(MessageBuilder.withPayload(message).build());
    }

}
