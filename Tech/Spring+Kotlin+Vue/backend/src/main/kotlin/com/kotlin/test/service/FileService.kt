package com.kotlin.test.service

import org.springframework.web.multipart.MultipartFile

interface FileService {
    fun uploadFile(fileList: MutableList<MultipartFile>)
}