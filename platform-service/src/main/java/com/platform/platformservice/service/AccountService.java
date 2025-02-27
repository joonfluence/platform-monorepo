package com.platform.platformservice.service;

import com.platform.platformservice.client.CommerceClient;
import com.platform.platformservice.domain.Mileage;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
  private final CommerceClient commerceClient;

  @CircuitBreaker(name = "commerceClient")
  public Mileage getAccount() {
    return commerceClient.getAccount();
  }

  @CircuitBreaker(name = "commerceClient")
  public String getSample() {
    return commerceClient.getSample();
  }

  private String fallbackType(Throwable t) {
    return "fallback invoked! exception type : " + t.getClass();
  }
}
