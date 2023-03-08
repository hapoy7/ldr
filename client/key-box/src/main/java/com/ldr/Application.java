package com.ldr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;
/**
 * @author 高振中
 * @date 2021-02-24 10:50:00
 */
@Slf4j
@EnableScheduling
@EnableAsync // 开启异步调用
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		log.info("文档地址:http://localhost:9999/swagger-ui/index.html");
	}
}
