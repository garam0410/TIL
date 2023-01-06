package com.kotlin.test.service

import com.kotlin.test.model.DocumentModel
import com.kotlin.test.model.ObjectModel
import org.springframework.web.multipart.MultipartFile

interface FileService {
    fun moveFileToRealPath(fileName: ObjectModel)
    fun saveTempFile(file: MultipartFile): DocumentModel
    fun deleteFile(fileName: ObjectModel)
    fun getFile(fileName: ObjectModel): ByteArray

    fun deleteAll()
}