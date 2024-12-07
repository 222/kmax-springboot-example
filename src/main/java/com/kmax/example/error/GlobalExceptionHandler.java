package com.kmax.example.error;

import com.kmax.example.common.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author youping.tan
 * @date 2024/11/20 14:18
 */
@RestControllerAdvice
@Order(2)
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public Response<Void> exception(Exception e) {
        LOGGER.error("未知异常拦截：", e);
        return Response.fail(AppError.BUSY);
    }

    /**
     * HTTP方法异常拦截处理
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Response<Void> exception(HttpRequestMethodNotSupportedException e) {
        LOGGER.error("HTTP方法异常拦截：", e);
        return Response.fail(AppError.HTTP_METHOD);
    }

    /**
     * 入参格式异常
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Response<Void> exception(HttpMessageNotReadableException e) {
        LOGGER.error("入参格式有误：", e);
        return Response.fail(AppError.DATA_FORMAT);
    }

    /**
     * 入参类型不匹配
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Response<Void> exception(MethodArgumentTypeMismatchException e) {
        LOGGER.error("入参类型不匹配：", e);
        return Response.fail(AppError.DATA_FORMAT);
    }


    /**
     * 404异常拦截处理
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public Response<Void> exception(NoHandlerFoundException e) {
        LOGGER.error("404异常拦截：", e);
        return Response.fail(AppError.NOT_FOUND);
    }


    /**
     * 自定义异常拦截处理
     */
    @ExceptionHandler(AppException.class)
    public Response<Void> exception(AppException e) {
        String code = e.getCode();
        String msg = e.getMsg();
        LOGGER.error("主动异常拦截：", e);
        return new Response<>(code, msg);
    }

    /**
     * 校验异常拦截处理
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<Void> expHandler(MethodArgumentNotValidException e, HttpServletRequest request) {
        AppError appError = AppError.VALID_ANOMALY;
        Response<Void> Response = new Response<>();
        BindingResult result = e.getBindingResult();
        LOGGER.error("请求[ {} ] {} 参数校验发生错误", request.getMethod(), request.getRequestURL());
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            Response.setCode(appError.getCode());
            StringBuilder sb = new StringBuilder();
            sb.append(appError.getMsg());
            sb.append("：");
            for (int i = 0; i < errors.size(); i++) {
                FieldError fieldError = (FieldError) errors.get(i);
                LOGGER.error("入参 {} = {} 校验错误：{}", fieldError.getField(), fieldError.getRejectedValue(), fieldError.getDefaultMessage());
                sb.append(fieldError.getDefaultMessage());
                if (i < (errors.size() - 1)) {
                    sb.append(",");
                }
            }
            Response.setMsg(sb.toString());
        }
        return Response;
    }

    /**
     * 上传的文件过大
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public Response<Void> exception(MaxUploadSizeExceededException e) {
        LOGGER.error("文件上传过大返回异常信息：", e);
        return Response.fail(AppError.MAX_UPLOAD_SIZE_EXCEEDED);
    }

}
