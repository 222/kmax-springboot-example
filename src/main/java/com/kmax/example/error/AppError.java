package com.kmax.example.error;

import com.alibaba.fastjson2.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author youping.tan
 * @date 2024/11/20 14:18
 */
public enum AppError {
    /**
     * 系统繁忙
     */

    SUCCESS("200", "成功"),

    /**
     * 操作异常
     * 40001
     */
    BUSY("40001", "服务器开小差，请稍后再试"),
    PERMISSION("40002", "权限不足"),
    ILLEGAL_ACCESS("40003", "非法访问"),
    HTTP_METHOD("40004", "请求方式有误"),
    RATE_LIMIT("40005", "限流了，请稍后重试"),
    DATA_FORMAT("40006", "入参格式有误"),
    NOT_FOUND("40007", "请求地址有误"),
    SERVICE_UNAVAILABLE("40008", "服务暂时不可用，请稍后再试"),
    RPC_FAIL("40009", "远程调用异常"),
    VALID_ANOMALY("40010", "参数校验异常"),
    MAX_UPLOAD_SIZE_EXCEEDED("40011", "上传的文件过大"),
    LOGIN_EXPIRED("40012", "由于您长时间未操作，请重新登录!"),

    /**
     * 业务异常
     * 50001
     */
    ADD_FAILED("50001", "新增失败"),
    UPDATE_FAILED("50002", "修改失败"),
    DELETE_FAILED("50003", "删除失败"),


    ;

    private final String code;
    private final String msg;

    AppError(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String resultMap(AppError error) {
        return resultMap(error, null);
    }

    public static String resultMap(AppError error, Object o) {
        Map<String, Object> resultMap = new HashMap<>(3);
        if (o != null) {
            resultMap.put("data", o);
        }
        resultMap.put("code", error.code);
        resultMap.put("msg", error.msg);
        return JSON.toJSONString(resultMap);
    }

    public static String resultMap(int code, String msg) {
        Map<String, Object> resultMap = new HashMap<>(3);
        resultMap.put("code", code);
        resultMap.put("msg", msg);
        return JSON.toJSONString(resultMap);
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
