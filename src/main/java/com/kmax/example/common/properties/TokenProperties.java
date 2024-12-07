package com.kmax.example.common.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author youping.tan
 * @date 2024/8/6 16:14
 */
@Configuration
@ConfigurationProperties(
        prefix = "token",
        ignoreUnknownFields = false
)
public class TokenProperties {

    @Value("${token.secret:123456}")
    private String secret;

    @Value("${token.expire:24}")
    private Integer expire;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Integer getExpire() {
        return expire;
    }

    public void setExpire(Integer expire) {
        this.expire = expire;
    }
}
