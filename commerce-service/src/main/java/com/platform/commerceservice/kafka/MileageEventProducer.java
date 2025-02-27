package com.platform.commerceservice.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.platform.commerceservice.kafka.event.MileageRequestEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MileageEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public MileageEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = new ObjectMapper();
    }

    public void sendMileageRequest(Long userId, int amount) {
        MileageRequestEvent event = new MileageRequestEvent(userId, amount);
        try {
            String eventJson = objectMapper.writeValueAsString(event);
            System.out.println("mileage-request-topic = " + eventJson);
            kafkaTemplate.send("mileage-request-topic", eventJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize event", e);
        }
    }
}

