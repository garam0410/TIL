package com.kotlin.test.service

import com.kotlin.test.model.FileModel
import com.kotlin.test.respository.DocumentRepository
import com.kotlin.test.util.FileUtil
import mu.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

private val log = KotlinLogging.logger {}

@Service
class FileServiceImpl(
    private val documentRepository: DocumentRepository
) : FileService {
    override fun uploadFile(fileList: MutableList<MultipartFile>): Unit {
        for (file in fileList){
            documentRepository.save(FileUtil().uploadFile(file).toEntity())
        }
    }

    override fun downloadFile(fileModel: FileModel) {
        FileUtil().downloadFile(fileModel)
    }
}