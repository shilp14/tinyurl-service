package com.tinyurl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TinyurlEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TinyurlEurekaServerApplication.class, args);
	}
}
