package com.kotlin.test.controller

import com.kotlin.test.model.FileModel
import com.kotlin.test.service.FileService
import com.kotlin.test.util.log
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.MultipartHttpServletRequest
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/api/file")
class FileController(
        private val fileService: FileService,
) {
    @PostMapping("/upload")
    fun uploadFileToTmpPath(@RequestParam fileList: MutableList<MultipartFile>) : MutableList<FileModel> {
        return fileService.uploadFileToTmpPath(fileList)
    }

//    @PostMapping("/save")
//    fun moveFileToRealPath(@RequestParam)
}