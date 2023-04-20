package com.example.sampleeventapplication.repository;

import com.example.sampleeventapplication.domain.SampleDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleEntityDetailRepository extends JpaRepository<SampleDetailEntity, Long> {
}
