package com.kotlin.test.service

import com.kotlin.test.model.DocumentModel
import com.kotlin.test.model.ObjectModel
import org.springframework.web.multipart.MultipartFile

interface FileService {
    fun moveFileToRealPath(fileName: ObjectModel)
    fun saveTempFile(file: MultipartFile): DocumentModel
<<<<<<< HEAD
    fun deleteFile(fileName: ObjectModel)
    fun getFile(fileName: ObjectModel): ByteArray
=======
    fun deleteFile(fileName: String)
    fun getFile(fileName: String): ByteArray
>>>>>>> acd1b888405e4fe332a5db20675a308f378f048f

    fun deleteAll()
}