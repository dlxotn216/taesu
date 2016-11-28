package com.mustache.webservice.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by kim on 2016-11-28.
 */
public class EchoHandler extends TextWebSocketHandler {
    private Map userMap = new HashMap();
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception{
        System.out.println(session.getId()+"연결됨");
        userMap.put(session.getId(), session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println(session.getId()+": "+message.getPayload());

        Iterator it =userMap.keySet().iterator();
        while(it.hasNext()){
            Object key= it.next();
            WebSocketSession ws= (WebSocketSession)userMap.get(key);
            ws.sendMessage(message);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println(session.getId()+" 종료됨");
    }
}
