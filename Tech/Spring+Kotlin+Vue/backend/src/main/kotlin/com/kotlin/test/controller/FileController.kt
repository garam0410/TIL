package com.kotlin.test.controller

import com.kotlin.test.service.FileService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/file")
class FileController(
    private val fileService: FileService
) {
    @PostMapping("/upload")
    fun uploadFile(@RequestParam("fileList") fileList: MutableList<MultipartFile>){
        return fileService.uploadFile(fileList)
    }

    @PostMapping("/download")
    fun downloadFile(){
        return fileService.downloadFile()
    }
}