package com.platform.commerceservice.service;

import com.platform.commerceservice.client.ExternalClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final ExternalClient externalClient;

    public void saveAccount() {
        System.out.println("save account completed");
    }
}
