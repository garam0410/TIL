package com.example.sampleeventapplication;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SampleEventController {
    private final SampleEventService sampleEventService;

    @PersistenceContext
    private final EntityManager entityManager;

    @GetMapping("/test")
    public void function() {
        log.info("start : entityManager - {}", entityManager.isOpen());
        sampleEventService.function();
        log.info("end : entityManager - {}", entityManager.isOpen());
    }
}
