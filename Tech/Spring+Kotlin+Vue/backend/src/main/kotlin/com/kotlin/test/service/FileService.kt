package com.kotlin.test.service

import com.kotlin.test.model.FileModel
import org.springframework.web.multipart.MultipartFile

interface FileService {
    fun uploadFileToTmpPath(fileList: MutableList<MultipartFile>): MutableList<FileModel>
    fun moveFileToRealPath(fileModel: FileModel)
}