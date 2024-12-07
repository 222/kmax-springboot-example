package com.kmax.example.service;

import com.kmax.example.common.LoginSession;
import com.kmax.example.common.RequestContext;
import com.kmax.example.common.properties.TokenProperties;
import com.kmax.example.error.AppError;
import com.kmax.example.util.JwtUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author youping.tan
 * @date 2024/12/1 20:49
 */
@Service
public class TokenService {

    @Resource
    private TokenProperties tokenProperties;

    public AppError valid(String token) {
        boolean result = JwtUtils.verifyToken(token, tokenProperties.getSecret());
        if (result) {
            LoginSession loginSession = JwtUtils.parseToken(token, tokenProperties.getSecret());
            RequestContext.put(loginSession);
            return AppError.SUCCESS;
        } else {
            return AppError.LOGIN_EXPIRED;
        }
    }
}
