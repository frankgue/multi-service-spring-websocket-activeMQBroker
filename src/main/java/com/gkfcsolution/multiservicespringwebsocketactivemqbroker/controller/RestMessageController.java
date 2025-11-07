package com.gkfcsolution.multiservicespringwebsocketactivemqbroker.controller;

import com.gkfcsolution.multiservicespringwebsocketactivemqbroker.service.WebSocketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created on 2025 at 22:25
 * File: null.java
 * Project: multi-service-spring-websocket-activeMQBroker
 *
 * @author Frank GUEKENG
 * @date 06/11/2025
 * @time 22:25
 */
@RestController
@Slf4j
@RequestMapping("/v1")
public class RestMessageController {

    @Autowired
    private WebSocketService webSocketService;

    @PostMapping("/{toUser}")
    public void sendMessage(@RequestBody String message, @PathVariable String toUser){
        log.info("Rest send message {} to user {}", message, toUser);
        webSocketService.notifyUser(toUser, message);
    }
}
