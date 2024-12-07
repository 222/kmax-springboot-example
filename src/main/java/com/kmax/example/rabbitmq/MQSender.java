package com.kmax.example.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author youping.tan
 * @date 2024/12/5 12:55
 */
@Slf4j
@Component
public class MQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 没有指定交换机会走默认的交换机，AMQP default
     * AMQP default是一个direct路由模式的交换机
     *
     * @param msg
     */
    public void send(InsuredMsg msg) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, msg);
    }

    public void fanout(String msg) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, "", msg);
    }

    public void sendDirect1(Object msg) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE, RabbitMQConfig.ROUTING_KEY1, msg);
    }

    public void sendDirect2(Object msg) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE, RabbitMQConfig.ROUTING_KEY2, msg);
    }
}
