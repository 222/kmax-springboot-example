package com.kmax.example.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author youping.tan
 * @date 2024/12/5 12:56
 */
@Component
@Slf4j
public class MQReceiver {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receive(InsuredMsg msg) {
        log.info("接收消息: {}", msg);
//        throw new AppException("500","无法处理");
        System.out.println("Received message: " + msg);
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE1)
    public void receive1(String msg) {log.info("从 queue_fanout01 接收消息-" + msg);
    }
    @RabbitListener(queues = RabbitMQConfig.QUEUE2)
    public void receive2(String msg) {
        log.info("从 queue_fanout02 接收消息-" + msg);
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE3)
    public void queue_direct1(Object msg){
        log.info("从 queue_direct1 接收消息-" + msg);
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE4)
    public void queue_direct2(Object msg){
        log.info("从 queue_direct2 接收消息-" + msg);
    }
}
