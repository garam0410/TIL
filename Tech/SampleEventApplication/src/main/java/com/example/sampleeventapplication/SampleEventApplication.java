package com.example.sampleeventapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;

@SpringBootApplication
public class SampleEventApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleEventApplication.class, args);
    }

}
