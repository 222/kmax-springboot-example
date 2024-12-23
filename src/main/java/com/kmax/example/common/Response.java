package com.kmax.example.common;

import com.kmax.example.error.AppError;

/**
 * @author youping.tan
 * @date 2024/4/30 14:33
 */
public class Response<T> {
    private String code = "200";
    private String msg = "成功";
    private T data;

    public static final Response<Void> SUCCESS = new Response<>();

    public static Response<Void> success() {
        return new Response<>();
    }

    public static Response<Void> fail(AppError appError) {
        String code = appError.getCode();
        String msg = appError.getMsg();
        return new Response<>(code, msg);
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(data);
    }

    public Response() {
    }

    public Response(T data) {
        this.data = data;
    }

    public Response(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
