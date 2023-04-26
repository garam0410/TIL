package com.example.sampleeventapplication.service;

import com.example.sampleeventapplication.repository.SampleEntityDetailRepository;
import com.example.sampleeventapplication.repository.SampleEntityRepository;
import com.example.sampleeventapplication.domain.SampleDetailEntity;
import com.example.sampleeventapplication.domain.SampleEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SampleEventService {

    private final SampleEntityRepository sampleEntityRepository;
    private final SampleEntityDetailRepository sampleEntityDetailRepository;

    @Transactional
    public void create() {
        SampleEntity sampleEntity = SampleEntity.builder()
                .text("test")
                .build();
        sampleEntityDetailRepository.save(new SampleDetailEntity());
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
        SampleDetailEntity sampleDetailEntity = getSampleDetailEntity(1L);
        sampleDetailEntity.publish();
        sampleEntity.publish();
        sampleEntityRepository.save(sampleEntity);
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
