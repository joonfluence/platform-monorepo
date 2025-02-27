package com.platform.commerceservice.controller;

import com.platform.commerceservice.domain.Mileage;
import com.platform.commerceservice.service.AccountService;
import com.platform.commerceservice.service.MileageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommerceController {
  private final AccountService accountService;
  private final MileageService mileageService;

  @GetMapping("/account")
  public Mileage getAccount() {
    System.out.println("getAccount");
    accountService.saveAccount();
    return mileageService.getMileage();
  }

  @GetMapping("/sample")
  public String getSample() {
    System.out.println("getSample");
    return "Done";
  }
}
