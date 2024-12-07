package com.kmax.example.common;

/**
 * @author youping.tan
 * @date 2024/12/1 20:43
 */
public class RequestContext {

    public static final ThreadLocal<LoginSession> CONTEXT = new ThreadLocal<>();

    private RequestContext() {

    }

    public static void put(LoginSession session) {
        CONTEXT.set(session);
    }
    public static LoginSession get() {
        return CONTEXT.get();
    }

    public static void remove() {
        CONTEXT.remove();
    }
}
