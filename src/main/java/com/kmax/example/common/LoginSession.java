package com.kmax.example.common;

import lombok.Data;
import java.io.Serializable;

/**
 * @author youping.tan
 * @date 2024/12/1 20:44
 */
@Data
public class LoginSession implements Serializable {
    private Integer userId;
    private String nickname;
    private String username;
    private String avatarUrl;
}
