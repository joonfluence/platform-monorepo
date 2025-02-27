package com.platform.externalservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController {

  @GetMapping("/price")
  public int getPrice(String itemNo) {
    return 10000;
  }
}
