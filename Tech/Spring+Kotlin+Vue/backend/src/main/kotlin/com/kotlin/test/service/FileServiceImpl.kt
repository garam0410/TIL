package com.kotlin.test.service

import com.kotlin.test.exception.ExceptionDefinition
import com.kotlin.test.exception.WebException
import com.kotlin.test.model.FileModel
import com.kotlin.test.respository.DocumentRepository
import com.kotlin.test.util.FileUtil
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class FileServiceImpl(
        private val documentRepository: DocumentRepository,
) : FileService {
    override fun uploadFileToTmpPath(fileList: MutableList<MultipartFile>): MutableList<FileModel> {

        if (fileList.isEmpty()) {
            throw WebException(ExceptionDefinition.UPLOAD_FILE_ERROR)
        }

        var tmpFileList: MutableList<FileModel> = mutableListOf()

        for (file in fileList) {
            tmpFileList.add(
                    documentRepository.save(FileUtil().uploadFileToTmpDir(file).toEntity())
            )
        }

        return tmpFileList
    }

    override fun moveFileToRealPath(fileModel: FileModel) {
//        FileUtil().moveFileToRealPath(fileModel)
    }
}