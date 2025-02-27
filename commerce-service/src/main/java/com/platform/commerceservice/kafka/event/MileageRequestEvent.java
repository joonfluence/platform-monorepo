package com.platform.commerceservice.kafka.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MileageRequestEvent {
    private Long userId;
    private int amount;
}
