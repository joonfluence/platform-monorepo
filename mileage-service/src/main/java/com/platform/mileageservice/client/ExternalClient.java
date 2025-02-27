package com.platform.mileageservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "external-client", url = "http://localhost:9091")
public interface ExternalClient {

  @GetMapping("/mileage")
  void getMileage();
}
