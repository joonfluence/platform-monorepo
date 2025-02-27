package com.platform.commerceservice.service;

import com.platform.commerceservice.client.ExternalClient;
import com.platform.commerceservice.domain.Mileage;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MileageService {
  private final ExternalClient externalClient;

  @CircuitBreaker(name = "externalClient")
  public Mileage getMileage() {
    return externalClient.getMileage();
  }

  private String fallbackType(Throwable t) {
    return "fallback invoked! exception type : " + t.getClass();
  }
}
