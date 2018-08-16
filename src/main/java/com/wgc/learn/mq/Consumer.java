package com.wgc.learn.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * mq消费者
 * Created by Administrator on 8/16/2018.
 */
@Component
public class Consumer {

    private static final Logger log = LoggerFactory.getLogger(Consumer.class);

    @RabbitListener(queues = "${myqueue}")
    public void handler(String message) {
        System.out.println("消费者接收到消息。。。"+message);
        log.info("Consumer> " + message);
    }
}
