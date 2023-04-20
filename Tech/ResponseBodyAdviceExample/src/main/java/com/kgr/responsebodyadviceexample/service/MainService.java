package com.kgr.responsebodyadviceexample.service;

import com.kgr.responsebodyadviceexample.domain.OtherEntity;
import com.kgr.responsebodyadviceexample.domain.TestEntity;
import com.kgr.responsebodyadviceexample.model.TestEntityResponseModel;
import com.kgr.responsebodyadviceexample.repository.OtherEntityRepository;
import com.kgr.responsebodyadviceexample.repository.TestEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MainService {

    private final TestEntityRepository testEntityRepository;
    private final OtherEntityRepository otherEntityRepository;

    @Transactional
    public TestEntityResponseModel insertData() {
        TestEntity testEntity = testEntityRepository.save(new TestEntity(1L, "string", 2));
        OtherEntity otherEntity = otherEntityRepository.save(new OtherEntity());
        return new TestEntityResponseModel(testEntity, otherEntity);
    }
}
