package com.wick.chat.demo;

import org.springframework.stereotype.Component;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * @author lxx
 * ServerEndpoint 这个注解有什么作用？
 * 这个注解用于标识作用在类上，它的主要功能是把当前类标识成一个WebSocket的服务端
 * 注解的值用户客户端连接访问的URL地址
 * @date 2021/10/12
 */
@ServerEndpoint("/demo")
@Component
public class WebSocketDemo {

    @OnMessage
    public String hello(String message) {
        System.out.println("Received : " + message);
        return message;
    }

    @OnOpen
    public void myOnOpen(Session session) {
        System.out.println("WebSocket opened: " + session.getId());
    }

    @OnClose
    public void myOnClose(CloseReason reason) {
        System.out.println("Closing a WebSocket due to " + reason.getReasonPhrase());
    }
}
