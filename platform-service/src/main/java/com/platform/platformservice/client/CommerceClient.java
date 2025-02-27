package com.platform.platformservice.client;

import com.platform.platformservice.domain.Mileage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "commerce-client", url = "http://localhost:9092")
public interface CommerceClient {

  @GetMapping("/account")
  Mileage getAccount();
}
