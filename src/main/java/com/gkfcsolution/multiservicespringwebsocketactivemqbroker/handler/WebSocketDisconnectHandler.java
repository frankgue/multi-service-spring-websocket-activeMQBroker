package com.gkfcsolution.multiservicespringwebsocketactivemqbroker.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.Optional;

/**
 * Created on 2025 at 16:09
 * File: null.java
 * Project: multi-service-spring-websocket-activeMQBroker
 *
 * @author Frank GUEKENG
 * @date 07/11/2025
 * @time 16:09
 */
@Slf4j
public class WebSocketDisconnectHandler<S> implements ApplicationListener<SessionDisconnectEvent> {

    public WebSocketDisconnectHandler(SimpMessageSendingOperations messagingTemplate) {
        super();
    }
    @Override
    public void onApplicationEvent(SessionDisconnectEvent event) {
        Optional.ofNullable(event.getUser()).ifPresent(user ->
                log.info("USer {} disconnected from session id {}", user.getName(), event.getSessionId())
        );
    }
}
