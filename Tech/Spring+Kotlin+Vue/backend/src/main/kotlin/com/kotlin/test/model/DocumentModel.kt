package com.kotlin.test.model

import com.kotlin.test.entity.Document

class DocumentModel(document: Document) {
    var id: Long? = document.id
    var fileName: String? = "/api/file/${document.fileName}"
}