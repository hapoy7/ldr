package com.gzz.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2022-05-26 14:50:00
 */
@Configuration
public class WebSocketConfig {
 
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
}
