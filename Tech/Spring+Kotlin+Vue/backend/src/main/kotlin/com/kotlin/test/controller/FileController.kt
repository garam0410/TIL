package com.kotlin.test.controller

import com.kotlin.test.model.DocumentModel
import com.kotlin.test.model.ObjectModel
import com.kotlin.test.service.FileService
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/file")
class FileController(
    private val fileService: FileService,
) {
    @PostMapping("/upload/many")
    fun uploadFileToTmpPath(@RequestParam fileList: MutableList<MultipartFile>) : MutableList<DocumentModel> {
        return fileService.uploadFileToTmpPath(fileList)
    }

    @PostMapping("/upload")
    fun uploadFileToTmpPath(@RequestParam file: MultipartFile): Long {
        return fileService.uploadOneFileToTmpPath(file)
    }

    @PostMapping("/save")
    fun moveFileToRealPath(@RequestBody objectModel: ObjectModel){
        return fileService.moveFileToRealPath(objectModel.fileId)
    }

    @PostMapping("/delete")
    fun deleteFile(@RequestBody objectModel: ObjectModel){
        return fileService.deleteFile(objectModel.fileId)
    }
}