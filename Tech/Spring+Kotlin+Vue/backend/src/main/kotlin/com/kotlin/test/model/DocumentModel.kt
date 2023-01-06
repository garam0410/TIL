package com.kotlin.test.model

import com.kotlin.test.entity.Document

class DocumentModel(document: Document) {

    var id: Long? = document.id
<<<<<<< HEAD
    var fileName: String? = document.fileName
    var fileUrl: String = "/api/file/$fileName"
=======
    var fileName: String? = "/api/file/${document.fileName}"
>>>>>>> acd1b888405e4fe332a5db20675a308f378f048f
}