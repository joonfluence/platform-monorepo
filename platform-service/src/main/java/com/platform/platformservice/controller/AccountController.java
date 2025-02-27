package com.platform.platformservice.controller;

import com.platform.platformservice.domain.Mileage;
import com.platform.platformservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {
  private final AccountService accountService;

  @GetMapping("/account")
  public Mileage getAccountAndMileage() {
    return accountService.getAccount();
  }
}
