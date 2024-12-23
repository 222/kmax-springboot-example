package com.kmax.example.common.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.nio.ByteBuffer;

/**
 * @author youping.tan
 * @date 2024/12/7 14:59
 */
@ServerEndpoint("/websocket/{taskId}")
@Component
@Slf4j
public class WebsocketServer {

    @OnOpen
    public void onOpen(Session session, @PathParam("taskId") String taskId) {
        log.error("客户端连接：{} taskId:{}", session.getId(), taskId);
    }

    @OnMessage
    public void onMessage(ByteBuffer message, Session session) throws Exception {
        session.getBasicRemote().sendText(String.valueOf(message.remaining()));
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) {
        log.error("客户端断开连接：{} 原因:{}", session.getId(), reason.getReasonPhrase());
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("Websocket连接错误:{}", error.getMessage());
    }

}
