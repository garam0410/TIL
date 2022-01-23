package com.kotlin.test.model

import com.kotlin.test.entity.Document

data class FileModel(
    var id: Long? = null,
    var fileName: String?,
    var fileLocation: String?
) {
    fun toEntity(): Document{
        return Document(
            fileName = this.fileName,
            fileLocation = this.fileLocation
        )
    }
}