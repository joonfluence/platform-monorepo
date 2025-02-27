package com.platform.commerceservice.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.platform.commerceservice.kafka.event.AccountSyncEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MileageEventConsumer {

    private final ObjectMapper objectMapper;
    private final MileageEventProducer mileageEventProducer;

    @KafkaListener(topics = "account-sync-topic", groupId = "commerce-group")
    public void consumeAccountSyncEvent(String message) {
        try {
            AccountSyncEvent event = objectMapper.readValue(message, AccountSyncEvent.class);
            System.out.println("Save User Account");
            System.out.println("Account synced: " + event.getEmail());
            mileageEventProducer.sendMileageRequest(1L, 20000);
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize event", e);
        }
    }
}
