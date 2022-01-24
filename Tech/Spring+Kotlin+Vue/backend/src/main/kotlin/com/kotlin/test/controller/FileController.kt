package com.kotlin.test.controller

import com.kotlin.test.model.FileModel
import com.kotlin.test.service.FileService
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/file")
class FileController(
    private val fileService: FileService,
) {
    @PostMapping("/upload")
    fun uploadFile(@RequestParam("fileList") fileList: MutableList<MultipartFile>) {
        return fileService.uploadFile(fileList)
    }
}