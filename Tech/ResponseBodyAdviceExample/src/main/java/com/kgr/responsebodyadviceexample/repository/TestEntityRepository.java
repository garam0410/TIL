package com.kgr.responsebodyadviceexample.repository;

import com.kgr.responsebodyadviceexample.domain.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestEntityRepository extends JpaRepository<TestEntity, Long> {
}
