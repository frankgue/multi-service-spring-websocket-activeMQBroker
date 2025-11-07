package com.gkfcsolution.multiservicespringwebsocketactivemqbroker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.*;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * Created on 2025 at 23:33
 * File: null.java
 * Project: multi-service-spring-websocket-activeMQBroker
 *
 * @author Frank GUEKENG
 * @date 06/11/2025
 * @time 23:33
 */
@Service
@RequiredArgsConstructor
public class WebSocketService {
    private final SimpMessagingTemplate messagingTemplate;


    public void notifyUser(final String userId, final String message) {
        this.send(userId, message);
    }

    @SneakyThrows
    private void send(String userId, String message) {
        String json = (new ObjectMapper()).writeValueAsString(new WebSocketResponseMessage(message));
        messagingTemplate.convertAndSendToUser(userId, "/topic/messages", json);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class WebSocketResponseMessage {

        private String content;

    }
}
