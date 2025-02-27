package com.platform.platformservice.controller;

import com.platform.platformservice.event.AccountSyncEvent;
import com.platform.platformservice.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final KafkaProducer kafkaProducer;

    @PostMapping("/account")
    public void getAccountAndMileage(@RequestBody AccountSyncEvent event) {
        kafkaProducer.sendAccountSyncEvent(event);
    }
}
