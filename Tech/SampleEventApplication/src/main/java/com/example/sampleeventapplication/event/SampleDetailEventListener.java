package com.example.sampleeventapplication.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SampleDetailEventListener {

    @EventListener
    public void publish(SampleDetailEvent event){
        log.info("Sample Detail Event Listen!!");
        log.info("sampleDetailEvent : {}", event.getBool());
    }
}
