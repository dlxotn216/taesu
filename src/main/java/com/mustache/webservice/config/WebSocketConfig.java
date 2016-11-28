package com.mustache.webservice.config;

import com.mustache.webservice.websocket.ChatWebSocketHandler;
import com.mustache.webservice.websocket.EchoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by kim on 2016-11-28.
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry){
        registry.addHandler(echoHandler(), "/echo.sockjs").withSockJS();
        registry.addHandler(chatHandler(), "/chat.sockjs").withSockJS();

    }

    @Bean
    public EchoHandler echoHandler(){
        return new EchoHandler();
    }

    @Bean
    public ChatWebSocketHandler chatHandler(){
        return new ChatWebSocketHandler();
    }
}
