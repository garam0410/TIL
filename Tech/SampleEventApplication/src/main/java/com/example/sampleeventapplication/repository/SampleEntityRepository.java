package com.example.sampleeventapplication.repository;

import com.example.sampleeventapplication.domain.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleEntityRepository extends JpaRepository<SampleEntity, Long> {
}
