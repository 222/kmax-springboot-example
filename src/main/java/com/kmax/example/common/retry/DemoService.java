package com.kmax.example.common.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author youping.tan
 * @date 2024/12/4 15:06
 */
@Service
@Slf4j
public class DemoService {


    @Retryable(retries = 3, fallback = "fallback")
    public void performTask(boolean success) {
        if (success) {
            log.info("success");
        } else {
            log.error("fail");
            throw new RuntimeException();
        }
    }

    public void fallback() {
        log.error("重试失败，调用回调接口");
    }
}
