package com.example.sampleeventapplication.common;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationEventPublisher implements ApplicationEventPublisherAware {

    private static ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        publisher = applicationEventPublisher;
    }

    public static <T> void registerEvent(T event) {
        publisher.publishEvent(event);
    }
}

