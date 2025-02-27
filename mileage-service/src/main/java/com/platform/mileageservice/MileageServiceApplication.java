package com.platform.mileageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MileageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MileageServiceApplication.class, args);
	}

}
