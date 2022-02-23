package com.kotlin.test.service

import com.kotlin.test.config.DocumentProperties
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
    private val properties: DocumentProperties
) : FileService {

    override fun saveTempFile(file: MultipartFile): DocumentModel {
        var document = Document(file, properties.tempPath)
        documentRepository.save(document)
        return DocumentModel(document)
    }

    override fun moveFileToRealPath(fileName: String) {
        var document: Document = documentRepository.findByFileName(fileName)
        document.moveFileToRealPath(properties.realPath)
    }

    override fun deleteFile(fileName: String) {
        var document: Document = documentRepository.findByFileName(fileName)
        document.deleteFile()
        documentRepository.delete(document)
    }

    @Transactional(readOnly = true)
    override fun getFile(fileName: String): ByteArray {
        var document = documentRepository.findByFileName(fileName)
        val inputStream: InputStream = File(document.filePath).inputStream()
        return inputStream.readBytes()
    }

    override fun deleteAll() {
        var list = documentRepository.findAll()

        for(doc in list){
            doc.deleteFile()
            documentRepository.delete(doc)
        }
    }
}