package com.example.sampleeventapplication.controller;

import com.example.sampleeventapplication.service.SampleEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SampleEventController {
    private final SampleEventService sampleEventService;

    @GetMapping("/create")
    public void create() {
        log.info("-----create-----");
        sampleEventService.create();
    }

    @GetMapping("/update")
    public void update() {
        log.info("-----update-----");
        sampleEventService.update();
    }

    @GetMapping("/publish")
    public void publish() {
        log.info("-----publish-----");
        sampleEventService.publish();
    }
}
