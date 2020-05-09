package com.carlos.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/8 18:33
 */
public interface StreamClient {

    String INPUT = "myMessageInput";

    String OUTPUT = "myMessageOutput";

    String INPUT2 = "myMessageInput2";

    String OUTPUT2 = "myMessageOutput2";

    @Input(INPUT)
    SubscribableChannel input();

    @Output(OUTPUT)
    MessageChannel output();

    @Input(INPUT2)
    SubscribableChannel input2();

    @Output(OUTPUT2)
    MessageChannel output2();


}
