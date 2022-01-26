package com.kotlin.test.controller

import com.kotlin.test.model.DocumentModel
import com.kotlin.test.model.ObjectModel
import com.kotlin.test.service.FileService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/file")
class FileController(
        private val fileService: FileService,
) {

    @PostMapping("/upload")
    fun uploadFileToTmpPath(@RequestParam file: MultipartFile): DocumentModel {
        return fileService.saveTempFile(file)
    }

    @PostMapping("/save")
    fun moveFileToRealPath(@RequestBody objectModel: ObjectModel) {
        return fileService.moveFileToRealPath(objectModel.fileName)
    }

    @PostMapping("/delete")
    fun deleteFile(@RequestBody objectModel: ObjectModel) {
        return fileService.deleteFile(objectModel.fileName)
    }

    @GetMapping("/{fileName}", produces = [MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE])
    fun getFile(@PathVariable("fileName") objectModel: ObjectModel): ByteArray {
        return fileService.getFile(objectModel.fileName)
    }
}