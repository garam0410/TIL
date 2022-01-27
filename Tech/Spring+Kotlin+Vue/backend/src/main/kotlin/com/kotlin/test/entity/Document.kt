package com.kotlin.test.entity

import com.kotlin.test.config.DocumentProperties
import com.kotlin.test.config.getStaticTempPath
import com.kotlin.test.exception.ExceptionDefinition
import com.kotlin.test.exception.WebException
import com.kotlin.test.util.log
import org.apache.tomcat.util.http.fileupload.FileUtils
import org.springframework.util.FileCopyUtils
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Document(file: MultipartFile) {
    @Id
    @GeneratedValue
    var id: Long? = null

    var fileName: String? = null
        protected set

    var filePath: String = DocumentProperties().tempPath
        protected set

    var fileSize: Long? = null
        protected set

    var contentType: String? = null
        protected set

    init {
        fileName = makeRandomFileName(file)
        fileSize = file.size
        filePath += fileName
        contentType = file.contentType
        saveTempFile(file, filePath)
    }

    fun saveTempFile(file: MultipartFile, tempPath: String) {
        if (file.isEmpty) {
            throw WebException(ExceptionDefinition.UPLOAD_FILE_ERROR)
        }
        if (file.size == null) {
            throw WebException(ExceptionDefinition.BAD_FILE_SIZE)
        }
        checkValidPath()
        FileCopyUtils.copy(file.inputStream, FileOutputStream(File(tempPath)))
    }

    fun moveFileToRealPath() {
        val tempFile = File(filePath)
        val realPath = DocumentProperties().realPath + fileName

        FileCopyUtils.copy(tempFile, File(realPath))
        filePath = realPath

        tempFile.delete()
    }

    fun deleteFile() {
        val file = File(filePath)
        if (!file.exists()) {
            throw WebException(ExceptionDefinition.NOT_FOUND_FILE)
        }
        file.delete()
    }

    private fun checkValidPath() {
        log().info(getStaticTempPath())
        if (!File(DocumentProperties().tempPath).exists()) {
            FileUtils.forceMkdir(File(DocumentProperties().tempPath))
        }
        if (!File(DocumentProperties().realPath).exists()) {
            FileUtils.forceMkdir(File(DocumentProperties().realPath))
        }
    }

    private fun makeRandomFileName(file: MultipartFile): String {
        val randomFileName = UUID.randomUUID().toString()
        return randomFileName + "." + getExtension(file)
    }

    private fun getExtension(file: MultipartFile): String {
        var extension: String = File(filePath + file.originalFilename).extension

        if (extension.isNullOrBlank()) {
            throw WebException()
        }

        return extension
    }
}