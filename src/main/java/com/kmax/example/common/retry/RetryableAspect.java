package com.kmax.example.common.retry;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author youping.tan
 * @date 2024/12/4 14:52
 */
@Aspect
@Component
public class RetryableAspect {

    @Around("@annotation(retryable)")
    public Object retry(ProceedingJoinPoint joinPoint, Retryable retryable) throws Throwable {
        int retries = retryable.retries();
        String fallbackMethod = retryable.fallback();
        int delay = retryable.delay();

        // 尝试调用方法
        for (int attempt = 0; attempt < retries; attempt++) {
            try {
                return joinPoint.proceed();
            } catch (Throwable ignore) {}
            Thread.sleep(delay);
        }
        // 调用失败回调方法
        if (!fallbackMethod.isEmpty()) {
            Object target = joinPoint.getTarget();
            Method method = target.getClass().getMethod(fallbackMethod);
            method.invoke(target);
        }
        return null;
    }

}
