package com.kotlin.test.respository

import com.kotlin.test.entity.TestInfo
import org.springframework.data.jpa.repository.JpaRepository

interface TestInfoRepository : JpaRepository<TestInfo, Long> {
}