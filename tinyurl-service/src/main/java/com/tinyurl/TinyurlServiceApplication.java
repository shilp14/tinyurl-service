package com.tinyurl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TinyurlServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TinyurlServiceApplication.class, args);
	}

}
