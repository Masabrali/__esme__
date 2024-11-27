package com.esme.expenses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EurekaClientThreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientThreeApplication.class, args);
	}

}
