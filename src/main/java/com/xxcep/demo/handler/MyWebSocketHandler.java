package com.xxcep.demo.handler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

@Component
public class MyWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private UserHandler userHandler;

    private final static Logger logger = LoggerFactory.getLogger(MyWebSocketHandler.class);

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        userHandler.handleMessage(session, message);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.debug("链接成功......");
        userHandler.addUser(session);
    }


    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        logger.debug("链接出错，关闭链接......");
        userHandler.error(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.debug("链接关闭......" + status.toString());
        userHandler.error(session);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}