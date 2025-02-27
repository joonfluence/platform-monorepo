package com.platform.mileageservice.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.platform.mileageservice.client.ExternalClient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class MileageRequestConsumer {
    private final ExternalClient externalClient;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "mileage-request-topic", groupId = "mileage-group")
    public void processMileageRequest(String message) {
        try {
            MileageRequestEvent event = objectMapper.readValue(message, MileageRequestEvent.class);
            externalClient.getMileage();
            System.out.println("event.getAmount()  " + event.getAmount() + " to userId : " + event.getUserId());
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to deserialize message", e);
        }
    }
}

@Getter
@Setter
@AllArgsConstructor
class MileageRequestEvent {
    private Long userId;
    private int amount;
}