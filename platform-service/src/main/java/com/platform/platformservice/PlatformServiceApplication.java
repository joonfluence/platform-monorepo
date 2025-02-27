package com.platform.platformservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PlatformServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(PlatformServiceApplication.class, args);
  }
}
