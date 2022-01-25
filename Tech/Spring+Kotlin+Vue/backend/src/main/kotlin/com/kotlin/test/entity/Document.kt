package com.kotlin.test.entity

import com.kotlin.test.model.DocumentModel
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Document(documentModel: DocumentModel){
    @Id
    @GeneratedValue
    private var id: Long? = null
    private var fileName: String? = documentModel.fileName
    private var filePath: String? = documentModel.filePath
    private var fileSize: Long? = documentModel.fileSize
    private var contentType: String? = documentModel.contentType

    fun getId() = id

    fun changePath(path: String) = (path.also { this.filePath = it })
}