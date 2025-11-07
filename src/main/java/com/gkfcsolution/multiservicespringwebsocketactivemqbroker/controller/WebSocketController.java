package com.gkfcsolution.multiservicespringwebsocketactivemqbroker.controller;

import com.gkfcsolution.multiservicespringwebsocketactivemqbroker.service.WebSocketService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created on 2025 at 23:26
 * File: null.java
 * Project: multi-service-spring-websocket-activeMQBroker
 *
 * @author Frank GUEKENG
 * @date 06/11/2025
 * @time 23:26
 */

@RestController
@Slf4j
@RequiredArgsConstructor
public class WebSocketController {

    @Autowired
    WebSocketService webSocketService;
    @MessageMapping("/message/{toUser}")
    public Boolean sendMessage(
            Principal principal,
            @Header String authKey,
            @DestinationVariable String toUser,
            @RequestBody WebSocketRequestMessage message
    ){
        log.info("Send message from user {} to user {}. Auth key {}", principal.getName(), toUser, authKey);
        webSocketService.notifyUser(toUser, message.getMessageContent());
        return Boolean.TRUE;
    }

    @Data
    public static class WebSocketRequestMessage {
        private String messageContent;
    }

}
