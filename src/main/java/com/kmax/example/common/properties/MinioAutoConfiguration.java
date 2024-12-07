package com.kmax.example.common.properties;

import com.kmax.example.minio.MinioTemplate;
import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author youping.tan
 * @date 2024/12/1 20:52
 */
@Configuration
public class MinioAutoConfiguration {

    @Resource
    private MinioProperties minioProperties;

    @Bean
    public MinioTemplate minioTemplate() {
        MinioClient minioClient = MinioClient.builder()
                .endpoint(minioProperties.getEndpoint())
                .credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey())
                .build();
        return new MinioTemplate(minioClient, minioProperties.getBucketName());
    }
}
