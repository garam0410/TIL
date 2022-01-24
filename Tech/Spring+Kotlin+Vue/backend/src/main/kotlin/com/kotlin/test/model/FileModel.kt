package com.kotlin.test.model

import com.kotlin.test.entity.Document

data class FileModel(
        var id: Long? = null,
        var fileName: String?,
        var filePath: String?,
        var fileSize: Long?,
        var contentType: String?,
) {
    fun toEntity(): Document {
        return Document(
                fileName = this.fileName,
                filePath = this.filePath,
                fileSize = this.fileSize,
                contentType = this.contentType
        )
    }
}