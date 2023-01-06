package com.example.customtablegeneratorproject.service;

import com.example.customtablegeneratorproject.entity.MoreTestEntity;
import com.example.customtablegeneratorproject.entity.TestEntity;
import com.example.customtablegeneratorproject.repository.MoreTestEntityRespository;
import com.example.customtablegeneratorproject.repository.TestEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MainService {

    private final TestEntityRepository testEntityRepository;
    private final MoreTestEntityRespository moreTestEntityRespository;

    @Transactional
    public void insertData() {
        TestEntity testEntity = testEntityRepository.save(new TestEntity(1L, "string", 2));
        moreTestEntityRespository.save(new MoreTestEntity(String.valueOf(testEntity.getId())));
    }
}
