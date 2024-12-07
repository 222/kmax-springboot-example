package com.kmax.example.error;

/**
 * @author youping.tan
 * @date 2024/11/20 14:18
 */
public class AppException extends RuntimeException {

    private static final long serialVersionUID = 5425794447623371924L;

    private final String code;
    private final String msg;

    public AppException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public AppException(AppError error) {
        this.code = error.getCode();
        this.msg = error.getMsg();
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}