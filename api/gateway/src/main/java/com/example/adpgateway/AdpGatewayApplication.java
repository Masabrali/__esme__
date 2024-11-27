package com.example.adpgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AdpGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdpGatewayApplication.class, args);
	}

}
