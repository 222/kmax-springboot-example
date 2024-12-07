package com.kmax.example.common.framework.thread;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author tanyp
 * @since 2023/6/25 15:23
 */
@ConfigurationProperties(prefix = "kmax")
public class ThreadPoolProperties {

    private Integer poolCpuNumber;
    private String poolName;

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public Integer getPoolCpuNumber() {
        return poolCpuNumber;
    }

    public void setPoolCpuNumber(Integer poolCpuNumber) {
        this.poolCpuNumber = poolCpuNumber;
    }
}
