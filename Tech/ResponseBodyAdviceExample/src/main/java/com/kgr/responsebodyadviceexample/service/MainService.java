package com.kgr.responsebodyadviceexample.service;

import com.kgr.responsebodyadviceexample.core.model.ResponseWrapper;
import com.kgr.responsebodyadviceexample.domain.TestEntity;
import com.kgr.responsebodyadviceexample.model.TestEntityResponseModel;
import com.kgr.responsebodyadviceexample.repository.TestEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MainService {

    private final TestEntityRepository testEntityRepository;

    @Transactional
    public ResponseWrapper insertData() {
        TestEntity testEntity = testEntityRepository.save(new TestEntity(1L, "string", 2));
        return new ResponseWrapper(new TestEntityResponseModel(testEntity));
    }
}
