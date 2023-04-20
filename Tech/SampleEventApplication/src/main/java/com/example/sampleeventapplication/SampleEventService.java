package com.example.sampleeventapplication;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.DomainEvents;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SampleEventService {

    private final SampleEntityRepository sampleEntityRepository;
    private final EntityManager entityManager;

    @Transactional
    @DomainEvents
    public void function() {

        log.info("start function : entityManager - {}", entityManager.isOpen());
        SampleEntity sampleEntity = SampleEntity.builder()
                .text("test")
                .build();

        sampleEntity.publish();
        sampleEntityRepository.save(sampleEntity);

        log.info("end function : entityManager - {}", entityManager.isOpen());
    }
}
