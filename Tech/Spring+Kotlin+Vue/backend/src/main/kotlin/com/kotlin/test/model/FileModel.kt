package com.kotlin.test.model

import com.kotlin.test.entity.Document

data class FileModel(
        var id: Long? = null,
        var fileName: String?,
        var fileSize: Long?,
        var contentType: String?,
) {
    fun toEntity(): Document = Document(
            fileName = this.fileName,
            fileSize = this.fileSize,
            contentType = this.contentType
    )
}