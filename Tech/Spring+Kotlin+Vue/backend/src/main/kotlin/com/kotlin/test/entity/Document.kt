package com.kotlin.test.entity

import com.kotlin.test.exception.ExceptionDefinition
import com.kotlin.test.exception.WebException
import org.springframework.util.FileCopyUtils
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Document(file: MultipartFile, path: String) {
    @Id
    @GeneratedValue
    var id: Long? = null
        protected set

    var fileName: String? = null
        protected set

    var filePath: String? = null
        protected set

    var fileSize: Long? = null
        protected set

    var contentType: String? = null
        protected set

    init {
        fileName = makeRandomFileName(file)
        fileSize = file.size
        filePath = path + fileName
        contentType = file.contentType
        saveTempFile(file, filePath!!)
    }

    fun saveTempFile(file: MultipartFile, tempPath: String) {
        if (file.isEmpty) {
            throw WebException(ExceptionDefinition.UPLOAD_FILE_ERROR)
        }
        if (file.size == 0L) {
            throw WebException(ExceptionDefinition.BAD_FILE_SIZE)
        }

        FileCopyUtils.copy(file.inputStream, FileOutputStream(File(tempPath)))
    }

    fun moveFileToRealPath(realPath: String) {
        val tempFile = File(filePath)
        val realPath = realPath + fileName

        FileCopyUtils.copy(tempFile, File(realPath))
        tempFile.delete()
        filePath = realPath
    }

    fun deleteFile() {
        val file = File(filePath)
        if (!file.exists()) {
            throw WebException(ExceptionDefinition.NOT_FOUND_FILE)
        }
        file.delete()
    }

    private fun makeRandomFileName(file: MultipartFile): String {
        val randomFileName = UUID.randomUUID().toString()
        return "$randomFileName.${getExtension(file)}"
    }

    private fun getExtension(file: MultipartFile): String {
        var extension: String = File(filePath + file.originalFilename).extension

        if (extension.isNullOrBlank()) {
            throw WebException()
        }

        extension.isNullOrBlank()

        return extension
    }
}