package com.platform.externalservice.service;

import com.platform.externalservice.domain.Mileage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MileageService {
  public Mileage getMileage() {
    return new Mileage(1L, 2000);
  }
}
