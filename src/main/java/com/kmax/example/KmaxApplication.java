package com.kmax.example;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author youping.tan
 * @date 2024-12-01 20:25:23
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class KmaxApplication {

    public static void main(String[] args) {
        SpringApplication.run(KmaxApplication.class, args);
    }

    /**
     * https://github.com/spring-projects/spring-boot/issues/19596
     */
    @Bean
    public ApplicationRunner hikariPool(DataSource dataSource) {
        System.setProperty("pagehelper.banner", "false");
        return args -> {
            try (Connection ignored = dataSource.getConnection()) {
            }
        };
    }

}
