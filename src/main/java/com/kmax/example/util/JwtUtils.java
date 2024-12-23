package com.kmax.example.util;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.kmax.example.common.LoginSession;
import com.kmax.example.error.AppException;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Map;

/**
 * @author youping.tan
 * @date 2024/8/6 14:49
 */
@Slf4j
public class JwtUtils {

    private JwtUtils() {}

    public static String createToken(Integer expires, String secret, LoginSession loginSession) {
        try {
            Integer userId = loginSession.getUserId();
            String username = loginSession.getUsername();
            Algorithm algorithm = Algorithm.HMAC256(secret);
            DateTime dateTime = DateUtil.offsetHour(new Date(), expires);
            return JWT.create()
                    .withExpiresAt(dateTime)
                    .withClaim("userId", userId)
                    .withClaim("username", username)
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            log.error("createToken error：", exception);
            throw new AppException("签发用户令牌失败");
        }
    }

    public static boolean verifyToken(String token, String secret) {
        try {
            com.auth0.jwt.JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
            return true;
        } catch (JWTVerificationException exception) {
            return false;
        }
    }

    public static LoginSession parseToken(String token, String secret) {
        try {
            DecodedJWT decodedJWT = com.auth0.jwt.JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
            Map<String, Claim> claims = decodedJWT.getClaims();
            Integer userId = claims.get("userId").asInt();
            String username = claims.get("username").asString();
            LoginSession loginSession = new LoginSession();
            loginSession.setUsername(username);
            loginSession.setUserId(userId);
            return loginSession;
        } catch (JWTVerificationException exception) {
            log.error("createToken error：", exception);
            throw new AppException("签发用户令牌失败");
        }
    }
}
