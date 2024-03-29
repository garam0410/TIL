package com.kotlin.test.controller

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
    fun uploadFileToTmpPath(@RequestParam file: MultipartFile) = fileService.saveTempFile(file)

    @PatchMapping("/save")
    fun moveFileToRealPath(@RequestBody objectModel: ObjectModel) = fileService.moveFileToRealPath(objectModel)

    @DeleteMapping("/delete")
    fun deleteFile(@RequestBody objectModel: ObjectModel) = fileService.deleteFile(objectModel)

    @GetMapping("/{fileName}", produces = [MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE])
<<<<<<< HEAD
    fun getFile(@PathVariable("fileName") objectModel: ObjectModel) = fileService.getFile(objectModel)

    @GetMapping("deleteAll")
=======
    fun getFile(@PathVariable("fileName") objectModel: ObjectModel) = fileService.getFile(objectModel.fileName)

    @GetMapping("/deleteAll")
>>>>>>> acd1b888405e4fe332a5db20675a308f378f048f
    fun deleteAll() = fileService.deleteAll()
}