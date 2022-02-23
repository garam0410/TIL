package com.kotlin.test.service

import com.kotlin.test.entity.Document
import com.kotlin.test.model.DocumentModel
import com.kotlin.test.model.ObjectModel
import org.springframework.web.multipart.MultipartFile

interface FileService {
    fun moveFileToRealPath(fileName: String)
    fun saveTempFile(file: MultipartFile): DocumentModel
    fun deleteFile(fileName: String)
    fun getFile(fileName: String): ByteArray

    fun deleteAll()
}