package com.kotlin.test.respository

import com.kotlin.test.entity.Document
import com.kotlin.test.model.FileModel
import org.springframework.data.jpa.repository.JpaRepository

interface DocumentRepository : JpaRepository<Document, Long> {
    fun save(document: Document):FileModel
}