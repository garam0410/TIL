package com.kotlin.test.service

import com.kotlin.test.model.DocumentModel
import org.springframework.web.multipart.MultipartFile

interface FileService {
    fun uploadFileToTmpPath(fileList: MutableList<MultipartFile>): MutableList<DocumentModel>
    fun moveFileToRealPath(documentModel: Long)
    fun uploadOneFileToTmpPath(file: MultipartFile): Long
    fun deleteFile(fileId: Long)
}