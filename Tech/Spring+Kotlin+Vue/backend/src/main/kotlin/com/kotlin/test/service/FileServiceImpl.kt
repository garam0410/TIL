package com.kotlin.test.service

import com.kotlin.test.exception.ExceptionDefinition
import com.kotlin.test.exception.WebException
import com.kotlin.test.respository.DocumentRepository
import com.kotlin.test.util.FileUtil
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class FileServiceImpl(
        private val documentRepository: DocumentRepository,
) : FileService {
    override fun uploadFile(fileList: MutableList<MultipartFile>): Unit {

        if (fileList == null) {
            throw WebException(ExceptionDefinition.UPLOAD_FILE_ERROR)
        }

        for (file in fileList) {
            documentRepository.save(FileUtil().uploadFile(file).toEntity())
        }
    }
}