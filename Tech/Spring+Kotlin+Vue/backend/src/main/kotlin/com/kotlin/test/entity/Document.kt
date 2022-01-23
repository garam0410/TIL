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
    private var fileLocation: String?,
) {
    fun writeFile(file: FileModel): Unit {
        fileName = file.fileName
        fileLocation = file.fileLocation
    }
}