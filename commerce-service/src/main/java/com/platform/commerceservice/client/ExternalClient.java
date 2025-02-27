package com.platform.commerceservice.client;

import com.platform.commerceservice.domain.Mileage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "external-client", url = "http://localhost:9091")
public interface ExternalClient {

  @GetMapping("/mileage")
  Mileage getMileage();
}
