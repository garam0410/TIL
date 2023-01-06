package com.kotlin.test.service

import com.kotlin.test.config.DocumentProperties
import com.kotlin.test.entity.Document
import com.kotlin.test.model.DocumentModel
import com.kotlin.test.model.ObjectModel
import com.kotlin.test.respository.DocumentRepository
import com.kotlin.test.util.log
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

    override fun moveFileToRealPath(objectModel: ObjectModel) {
        var document: Document = documentRepository.findByFileName(objectModel.fileName)
        document.moveFileToRealPath(properties.realPath)
    }

    override fun deleteFile(objectModel: ObjectModel) {
        var document: Document = documentRepository.findByFileName(objectModel.fileName)
        document.deleteFile()
        documentRepository.delete(document)
    }

    @Transactional(readOnly = true)
    override fun getFile(objectModel: ObjectModel): ByteArray {
        var document = documentRepository.findByFileName(objectModel.fileName)
        val inputStream: InputStream = File(document.filePath).inputStream()
        return inputStream.readBytes()
    }

    override fun deleteAll() {
<<<<<<< HEAD
        var list:List<Document> = documentRepository.findAll()

        log().info(list.size.toString())
=======
        var list = documentRepository.findAll()
>>>>>>> acd1b888405e4fe332a5db20675a308f378f048f

        for(doc in list){
            doc.deleteFile()
            documentRepository.delete(doc)
        }
    }
}