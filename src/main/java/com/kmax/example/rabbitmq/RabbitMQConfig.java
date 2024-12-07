package com.kmax.example.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author youping.tan
 * @date 2024/12/5 12:50
 */
@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "example_queue";

    /**
     * 创建队列
     * 1. 配置队列
     * 2. 队列名为 queue
     * 3. true 表示: 持久化 (不填，默认为true,默认持久化)
     * durable： 队列是否持久化。 队列默认是存放到内存中的，rabbitmq 重启则丢失，
     * 若想重启之后还存在则队列要持久化，
     * 保存到 Erlang 自带的 Mnesia 数据库中，当 rabbitmq 重启之后会读取该数据库
     *
     * @return
     */
    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, true);
    }


    public static final String EXCHANGE_NAME = "example_exchange";
    public static final String QUEUE1 = "example_queue1";
    public static final String QUEUE2 = "example_queue2";



    /**
     * fanout
     */
    @Bean
    public Queue queue1() {
        return new Queue(QUEUE1, true);
    }

    @Bean
    public Queue queue2() {
        return new Queue(QUEUE2, true);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(queue1()).to(fanoutExchange());
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(fanoutExchange());
    }

    /**
     * direct
     */
    public static final String QUEUE3 = "example_queue3";
    public static final String QUEUE4 = "example_queue4";
    public static final String DIRECT_EXCHANGE = "example_direct_exchange";
    public static final String ROUTING_KEY1 = "example_routing_key1";
    public static final String ROUTING_KEY2 = "example_routing_key2";

    @Bean
    public Queue queue3() {
        return new Queue(QUEUE3, true);
    }
    @Bean
    public Queue queue4() {
        return new Queue(QUEUE4, true);
    }
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE);
    }
    @Bean
    public Binding binding3() {
        return BindingBuilder.bind(queue3()).to(directExchange()).with(ROUTING_KEY1);
    }
    @Bean
    public Binding binding4() {
        return BindingBuilder.bind(queue4()).to(directExchange()).with(ROUTING_KEY2);
    }


}
