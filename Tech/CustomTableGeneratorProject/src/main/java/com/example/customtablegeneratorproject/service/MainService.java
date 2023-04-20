package com.example.customtablegeneratorproject.service;

import com.example.customtablegeneratorproject.component.SpringApplicationContext;
import com.example.customtablegeneratorproject.entity.MoreTestEntity;
import com.example.customtablegeneratorproject.entity.TestEntity;
import com.example.customtablegeneratorproject.repository.MoreTestEntityRespository;
import com.example.customtablegeneratorproject.repository.TestEntityRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.spi.ServiceRegistryAwareService;
import org.hibernate.service.spi.ServiceRegistryImplementor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MainService {

    private final TestEntityRepository testEntityRepository;
    private final MoreTestEntityRespository moreTestEntityRespository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public void insertData() {
        TestEntity testEntity = testEntityRepository.save(new TestEntity(1L, "string", 2));
        moreTestEntityRespository.save(new MoreTestEntity(String.valueOf(testEntity.getId())));
    }
}
