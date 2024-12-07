package com.kmax.example;

import com.kmax.example.common.retry.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KmaxApplicationTests {

    @Autowired
    private DemoService demoService;

    @Test
    void contextLoads() {
//        demoService.performTask(true);
        demoService.performTask(false);
    }

}
