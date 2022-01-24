package com.kotlin.test.entity

import com.kotlin.test.model.FileModel
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Document(
        @Id
        @GeneratedValue
        private var id: Long? = null,
        private var fileName: String?,
        private var filePath: String?,
        private var fileSize: Long?,
        private var contentType: String?,
) {
//    fun writeFile(file: FileModel): Unit {
//        fileName = file.fileName
//        filePath = file.filePath
//        fileSize = file.fileSize
//        contentType = file.contentType
//    }
}