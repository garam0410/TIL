package com.example.sampleeventapplication.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SampleEventListener {

    @EventListener
    public void sampleEventListener(SampleEvent sampleEvent){
        log.info("sampleEvent : {}", sampleEvent);
//        log.info(String.valueOf(sampleEvent.id));
//        log.info(sampleEvent.text);
    }
}
