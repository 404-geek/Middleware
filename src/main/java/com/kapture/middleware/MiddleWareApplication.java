package com.kapture.middleware;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableMongoRepositories
@SpringBootApplication
@EnableScheduling
public class MiddleWareApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(MiddleWareApplication.class, args);
	}
}
