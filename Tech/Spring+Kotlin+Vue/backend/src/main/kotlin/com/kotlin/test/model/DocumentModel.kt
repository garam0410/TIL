package com.kotlin.test.model

import com.kotlin.test.entity.Document

data class DocumentModel(
    var id: Long? = 0,
    var fileName: String?,
    var filePath: String?,
    var fileSize: Long?,
    var contentType: String?,
) {
    fun toEntity(): Document = Document(this)
}