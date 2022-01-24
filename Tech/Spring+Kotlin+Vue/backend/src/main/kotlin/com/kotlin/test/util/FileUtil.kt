package com.kotlin.test.util

import com.kotlin.test.exception.ExceptionDefinition
import com.kotlin.test.exception.WebException
import com.kotlin.test.model.FileModel
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream

class FileUtil {

    private val dirPath: String = "/Users/kgr/Desktop/TIL/Tech/Spring+Kotlin+Vue/backend/src/images"

    fun uploadFile(file: MultipartFile): FileModel {

        if (file.bytes == null) {
            throw WebException(ExceptionDefinition.BAD_FILE_SIZE)
        }

        val path: String = dirPath + file.originalFilename

        var writer = FileOutputStream(File(path))
        writer.write(file.bytes)
        writer.close()

        return FileModel(
            fileName = file.originalFilename,
            filePath = path,
            fileSize = file.size,
            contentType = file.contentType
        )
    }
}