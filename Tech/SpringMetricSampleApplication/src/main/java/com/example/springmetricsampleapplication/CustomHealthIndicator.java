package com.example.springmetricsampleapplication;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up()
                .withDetail("category", "value1")
                .withDetail("name", "value2")
                .withDetail("type", "value3")
                .withDetail("host", "value3")
                .withDetail("port", "value3")
                .withDetail("status", "value3")
                .withDetail("message", "value3")
                .withDetail("duration", "value3")
                .build();
    }
}
