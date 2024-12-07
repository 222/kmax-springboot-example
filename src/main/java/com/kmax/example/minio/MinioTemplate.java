package com.kmax.example.minio;

import cn.hutool.http.ContentType;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author youping.tan
 * @date 2024/12/1 20:52
 */
public class MinioTemplate {
    private final MinioClient minioClient;
    private final String bucketName;

    public MinioTemplate(MinioClient minioClient, String bucketName) {
        this.minioClient = minioClient;
        this.bucketName = bucketName;
    }

    public void upload(String objectName, InputStream inputStream) throws Exception {
        PutObjectArgs putObjectArgs = PutObjectArgs.builder().bucket(bucketName)
                .object(objectName)
                .stream(inputStream, inputStream.available(), -1)
                .contentType(ContentType.OCTET_STREAM.getValue())
                .build();
        minioClient.putObject(putObjectArgs);
    }

    public void download(String objectName, OutputStream outputStream) throws Exception {
        GetObjectArgs getObjectArgs = GetObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .build();
        minioClient.getObject(getObjectArgs);
    }
}
