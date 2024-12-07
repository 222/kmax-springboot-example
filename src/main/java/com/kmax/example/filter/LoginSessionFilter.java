package com.kmax.example.filter;

import com.kmax.example.common.RequestContext;
import com.kmax.example.common.properties.FilterProperties;
import com.kmax.example.error.AppError;
import com.kmax.example.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author youping.tan
 * @date 2024/12/1 20:33
 */
@Component
@Slf4j
public class LoginSessionFilter extends OncePerRequestFilter {

    @Resource
    private FilterProperties filterProperties;
    @Resource
    private TokenService tokenService;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
//        String requestURI = request.getRequestURI();
//        boolean pass = filterProperties.isExcludeAuthUri(requestURI);
//        if (pass) {
//            log.info("跳过LoginSessionFilter，不检测token!");
//        }
//        return pass;
        String uri = request.getRequestURI();
        return uri.startsWith("/open/");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            String token = request.getHeader("X-API-TOKEN");
            String requestURI = request.getRequestURI();
            log.info("请求地址:{} check token:{}", requestURI, token);
            if (StringUtils.isNotBlank(token)) {
                AppError appError = tokenService.valid(token);
                if (appError.equals(AppError.SUCCESS)) {
                    chain.doFilter(request, response);
                } else {
                    resp(requestURI, response, appError);
                }
            } else {
                resp(requestURI, response, AppError.BUSY);
            }
        } finally {
            RequestContext.remove();
        }
    }

    public void resp(String requestURI, HttpServletResponse response, AppError appError) {
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        try {
            final String result = AppError.resultMap(appError);
            log.warn("[{}] filter not pass {}", requestURI, result);
            response.getWriter().write(result);
            response.getWriter().flush();
        } catch (Exception e) {
            log.error("响应失败!");
        }
    }
}
