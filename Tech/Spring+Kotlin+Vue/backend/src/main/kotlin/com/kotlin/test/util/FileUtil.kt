package com.kotlin.test.util

import com.kotlin.test.model.FileModel
import mu.KotlinLogging
import org.springframework.web.multipart.MultipartFile
import java.io.FileOutputStream

private val log = KotlinLogging.logger {}

class FileUtil {
    fun uploadFile(file: MultipartFile): FileModel {
        var writer = FileOutputStream(file.originalFilename)
        writer.write(file.bytes)
        writer.close()

        return FileModel(
            fileName = file.originalFilename,
            fileLocation = file.originalFilename
        )
    }

    fun downloadFile(fileModel: FileModel) {

    }
}