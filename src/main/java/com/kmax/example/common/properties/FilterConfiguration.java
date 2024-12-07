package com.kmax.example.common.properties;

import com.kmax.example.filter.LoginSessionFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author youping.tan
 * @date 2024/12/1 20:32
 */
@Configuration
public class FilterConfiguration {

    @Resource
    private LoginSessionFilter loginSessionFilter;

    @Bean
    public FilterRegistrationBean<LoginSessionFilter> filterRegistrationBean() {
        FilterRegistrationBean<LoginSessionFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(loginSessionFilter);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.setName("loginSessionFilter");
        return filterRegistrationBean;
    }
}
