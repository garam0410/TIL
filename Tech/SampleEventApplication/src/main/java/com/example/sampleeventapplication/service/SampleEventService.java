package com.example.sampleeventapplication.service;

import com.example.sampleeventapplication.event.SampleDetailEvent;
import com.example.sampleeventapplication.event.SampleEvent;
import com.example.sampleeventapplication.repository.SampleEntityDetailRepository;
import com.example.sampleeventapplication.repository.SampleEntityRepository;
import com.example.sampleeventapplication.domain.SampleDetailEntity;
import com.example.sampleeventapplication.domain.SampleEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SampleEventService {

    private final SampleEntityRepository sampleEntityRepository;
    private final SampleEntityDetailRepository sampleEntityDetailRepository;

    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public void create() {
        SampleDetailEntity sampleDetailEntity = new SampleDetailEntity();
        SampleEntity sampleEntity = SampleEntity.builder()
                .text("test")
                .sampleDetailEntity(sampleDetailEntity)
                .published(false)
                .build();
        sampleEntityDetailRepository.save(sampleDetailEntity);
        sampleEntityRepository.save(sampleEntity);
    }

    @Transactional
    public void update() {
        SampleEntity sampleEntity = getSampleEntity(1L);
        sampleEntity.addStr();
    }

    @Transactional
    public void publish() {
        SampleEntity sampleEntity = getSampleEntity(1L);
        sampleEntity.publish();
    }

    private SampleEntity getSampleEntity(Long id) {
        return sampleEntityRepository.findById(id)
                .orElseThrow();
    }

    private SampleDetailEntity getSampleDetailEntity(Long id) {
        return sampleEntityDetailRepository.findById(id)
                .orElseThrow();
    }
}
