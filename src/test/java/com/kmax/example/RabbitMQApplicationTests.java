package com.kmax.example;

import cn.hutool.core.util.IdUtil;
import com.kmax.example.rabbitmq.InsuredMsg;
import com.kmax.example.rabbitmq.MQSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitMQApplicationTests {

    @Autowired
    private MQSender mqSender;

    @Test
    void contextLoads() {
        InsuredMsg insuredMsg = new InsuredMsg();
        insuredMsg.setInsuranceName("腾邦保险2024-145-77");
        insuredMsg.setInsuranceId(IdUtil.fastSimpleUUID());
        insuredMsg.setOrderId(IdUtil.getSnowflakeNextId());
        mqSender.send(insuredMsg);
//        mqSender.sendDirect1("Hello sendDirect1");
//        mqSender.sendDirect2("Hello sendDirect2");
    }

}
