package com.kotlin.test.service

import com.kotlin.test.model.FileModel
import org.springframework.web.multipart.MultipartFile

interface FileService {
    fun uploadFile(fileList: MutableList<MultipartFile>)
    fun downloadFile(fileModel: FileModel)
}