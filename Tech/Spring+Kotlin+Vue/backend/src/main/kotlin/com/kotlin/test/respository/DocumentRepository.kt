package com.kotlin.test.respository

import com.kotlin.test.entity.Document
import org.springframework.data.jpa.repository.JpaRepository

interface DocumentRepository : JpaRepository<Document, Long> {
}