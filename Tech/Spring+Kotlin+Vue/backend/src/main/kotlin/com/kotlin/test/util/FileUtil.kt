package com.kotlin.test.util

import com.kotlin.test.exception.ExceptionDefinition
import com.kotlin.test.exception.WebException
import com.kotlin.test.model.FileModel
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream

class FileUtil {

    private val tmpDir: String = "C:\\Users\\User\\Desktop\\TIL\\Tech\\Spring+Kotlin+Vue\\backend\\src\\tmpDir\\"
    private val readDir: String = "C:\\Users\\User\\Desktop\\TIL\\Tech\\Spring+Kotlin+Vue\\backend\\src\\realDir\\"

    fun uploadFileToTmpDir(file: MultipartFile): FileModel {

        if (file.bytes.isEmpty()) {
            throw WebException(ExceptionDefinition.BAD_FILE_SIZE)
        }

        val path: String = tmpDir + file.originalFilename

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