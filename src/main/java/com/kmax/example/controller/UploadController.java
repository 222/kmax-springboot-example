package com.kmax.example.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import com.kmax.example.common.Response;
import com.kmax.example.common.properties.MinioProperties;
import com.kmax.example.minio.MinioTemplate;
import com.kmax.example.param.resp.MinioUpload;
import com.kmax.example.param.resp.UploadEnv;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author youping.tan
 * @date 2024/12/1 20:58
 */
@RestController
public class UploadController {

    @Resource
    private MinioProperties minioProperties;
    @Resource
    private MinioTemplate minioTemplate;

    @GetMapping("/upload/env")
    public Response<UploadEnv> env() {
        UploadEnv env = new UploadEnv();
        env.setBucketName(minioProperties.getBucketName());
        env.setEndpoint(minioProperties.getEndpoint());
        env.setPrefix(minioProperties.getEndpoint() + "/" + minioProperties.getBucketName());
        return Response.success(env);
    }

    @PostMapping("/upload")
    public Response<MinioUpload> upload(@RequestParam("file") MultipartFile file) throws Exception {
        String suffix = FileUtil.getSuffix(file.getOriginalFilename());
        String fileName = IdUtil.fastSimpleUUID();
        String date = DateUtil.format(new Date(), "yyyyMMddHHmmss");
        String objectName = String.format("%s/%s.%s", date, fileName, suffix);
        minioTemplate.upload(objectName, file.getInputStream());
        MinioUpload upload = new MinioUpload();
        String endpoint = minioProperties.getEndpoint();
        String bucketName = minioProperties.getBucketName();
        upload.setFullUrl(endpoint + "/" + bucketName + objectName);
        upload.setObjectName(objectName);
        return Response.success(upload);
    }
}
