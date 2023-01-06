package com.example.customtablegeneratorproject.repository;

import com.example.customtablegeneratorproject.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestEntityRepository extends JpaRepository<TestEntity, Long> {
}
