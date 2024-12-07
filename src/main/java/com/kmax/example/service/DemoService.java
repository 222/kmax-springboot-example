package com.kmax.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author youping.tan
 * @date 2024/12/7 18:11
 */
@Slf4j
@Service
public class DemoService {

    @Async("cpuDenseExecutor")
    public void cpuDenseExecutor() {
        log.info("test-cpuDenseExecutor-async");
    }


    @Async("ioDenseExecutor")
    public void ioDenseExecutor() {
        log.info("test-ioDenseExecutor-async");
    }
}
