package com.kmax.example.common.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author youping.tan
 * @date 2024/12/1 20:34
 */
@Configuration
public class FilterProperties {

    @Value("${manager.filter.exclude.auth.uri:/doc.html}")
    private String excludeAuthUri;

    public boolean isExcludeAuthUri(String requestUri) {
        return Arrays.stream(Optional.ofNullable(excludeAuthUri)
                        .map(excludeAuthUri -> excludeAuthUri.split(","))
                        .orElse(new String[0]))
                .anyMatch(excludeAuthUri -> new AntPathMatcher().match(excludeAuthUri.trim(), requestUri));
    }
}
