package com.platform.externalservice.controller;

import com.platform.externalservice.domain.Mileage;
import com.platform.externalservice.service.MileageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MileageController {
  private final MileageService mileageService;

  @GetMapping("/mileage")
  public Mileage getMileage() {
    return mileageService.getMileage();
  }
}
