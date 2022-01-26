package com.kotlin.test.service

import com.kotlin.test.entity.Document
import com.kotlin.test.model.DocumentModel
import com.kotlin.test.respository.DocumentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.InputStream

@Transactional
@Service
class FileServiceImpl(
        private val documentRepository: DocumentRepository,
) : FileService {

    override fun saveTempFile(file: MultipartFile): DocumentModel {
        var document = Document(file)
        documentRepository.save(document)
        return DocumentModel(document)
    }

    override fun moveFileToRealPath(fileName: String) {
        var document: Document = getFileInfo(fileName)
        document.moveFileToRealPath()
    }

    override fun deleteFile(fileName: String) {
        var document: Document = getFileInfo(fileName)
        document.deleteFile()
        documentRepository.delete(document)
    }

    @Transactional(readOnly = true)
    override fun getFile(fileName: String): ByteArray {
        var document = getFileInfo(fileName)
        val inputStream: InputStream = File(document.filePath).inputStream()
        return inputStream.readBytes()
    }

    @Transactional(readOnly = true)
    fun getFileInfo(fileName: String): Document {
        return documentRepository.findByFileName(fileName)
    }
}