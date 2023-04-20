package com.kgr.responsebodyadviceexample.repository;

import com.kgr.responsebodyadviceexample.domain.OtherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtherEntityRepository extends JpaRepository<OtherEntity, Long> {
}
