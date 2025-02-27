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
    System.out.println("유저 검증 및 유저 정보 조회");
    return commerceClient.getAccount();
  }

  private String fallbackType(Throwable t) {
    return "fallback invoked! exception type : " + t.getClass();
  }
}
