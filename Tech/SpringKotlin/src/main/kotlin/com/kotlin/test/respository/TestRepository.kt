package com.kotlin.test.respository

import com.kotlin.test.entity.Test
import org.springframework.data.jpa.repository.JpaRepository

interface TestRepository : JpaRepository<Test, Long> {
}