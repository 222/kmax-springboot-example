package com.kmax.example.param.resp;

import lombok.Data;

/**
 * @author youping.tan
 * @date 2024/12/1 21:00
 */
@Data
public class UploadEnv {
    private String bucketName;
    private String endpoint;
    private String prefix;
}
