package com.kmax.example.common.netty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author tanyp
 * @since 2023/2/27 10:06
 */
@Configuration
@ConfigurationProperties(prefix = "netty")
public class NettyConfig {
    @Value("${netty.host:localhost}")
    private String host;
    @Value("${netty.port:7397}")
    private Integer port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
