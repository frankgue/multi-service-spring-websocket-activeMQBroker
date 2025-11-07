package com.gkfcsolution.multiservicespringwebsocketactivemqbroker.config;

import com.gkfcsolution.multiservicespringwebsocketactivemqbroker.handler.WebSocketConnectHandler;
import com.gkfcsolution.multiservicespringwebsocketactivemqbroker.handler.WebSocketDisconnectHandler;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

/**
 * Created on 2025 at 16:25
 * File: null.java
 * Project: multi-service-spring-websocket-activeMQBroker
 *
 * @author Frank GUEKENG
 * @date 07/11/2025
 * @time 16:25
 */
@Configuration
public class WebSocketHandlerConfig<S extends Session> {

    @Bean
    public WebSocketConnectHandler<S> webSocketConnectHandler(SimpMessageSendingOperations messageTemplate){
        return new WebSocketConnectHandler<>(messageTemplate);
    }

    @Bean
    public WebSocketDisconnectHandler<S> webSocketDisconnectHandler(SimpMessageSendingOperations messageTemplate){
        return new WebSocketDisconnectHandler<>(messageTemplate);
    }
}
