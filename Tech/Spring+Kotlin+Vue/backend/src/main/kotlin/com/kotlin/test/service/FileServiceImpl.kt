package com.kotlin.test.service

import com.kotlin.test.entity.Document
import com.kotlin.test.exception.ExceptionDefinition
import com.kotlin.test.exception.WebException
import com.kotlin.test.model.DocumentModel
import com.kotlin.test.respository.DocumentRepository
import com.kotlin.test.util.FileUtil
import com.kotlin.test.util.log
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class FileServiceImpl(
    private val documentRepository: DocumentRepository,
) : FileService {
    override fun uploadFileToTmpPath(fileList: MutableList<MultipartFile>): MutableList<DocumentModel> {

        if (fileList.isEmpty()) {
            throw WebException(ExceptionDefinition.UPLOAD_FILE_ERROR)
        }

        var tmpFileList: MutableList<DocumentModel> = mutableListOf()

        for (file in fileList) {
            tmpFileList.add(
                documentRepository.save(FileUtil().uploadFileToTmpDir(file).toEntity())
            )
        }

        return tmpFileList
    }

    override fun uploadOneFileToTmpPath(file: MultipartFile): Long {
        if(file.isEmpty){
            throw WebException(ExceptionDefinition.UPLOAD_FILE_ERROR)
        }

        var document: Document = documentRepository.saveAndFlush(FileUtil().uploadFileToTmpDir(file).toEntity())

        return document.getId()!!
    }

    override fun moveFileToRealPath(fileId: Long) {
        var document: Document = getFileInfo(fileId)
        FileUtil().moveFileToRealPath(document)
    }

    override fun deleteFile(fileId: Long) {
        var document: Document = getFileInfo(fileId)
        FileUtil().deleteFile(document)
        documentRepository.delete(document)
    }

    fun getFileInfo(fileId: Long): Document {
        return documentRepository.findByIdOrNull(fileId)
            ?: throw WebException(ExceptionDefinition.NOT_FIND_FILE)
    }
}