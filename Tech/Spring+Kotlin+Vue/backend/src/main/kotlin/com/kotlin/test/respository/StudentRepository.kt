package com.kotlin.test.respository

import com.kotlin.test.entity.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student, Long> {
    fun findByName(name: String): Student?
}