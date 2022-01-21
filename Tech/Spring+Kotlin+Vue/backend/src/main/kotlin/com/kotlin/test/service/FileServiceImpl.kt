package com.kotlin.test.service

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class FileServiceImpl(

) : FileService {
    override fun uploadFile(fileList: MutableList<MultipartFile>) {

    }

    override fun downloadFile() {

    }
}