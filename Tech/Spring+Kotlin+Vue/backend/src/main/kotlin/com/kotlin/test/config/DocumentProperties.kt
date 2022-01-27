package com.kotlin.test.config

import com.kotlin.test.util.log
import org.apache.tomcat.util.http.fileupload.FileUtils
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.File
import javax.annotation.PostConstruct

@Component
class DocumentProperties {

//    @Value("\${temp}")
//    var tempPath: String = "C:/Users/User/Desktop/TIL/Tech/Spring+Kotlin+Vue/backend/src/tmpDir/"
//
//    @Value("\${real}")
//    var realPath: String = "C:/Users/User/Desktop/TIL/Tech/Spring+Kotlin+Vue/backend/src/realDir/"

    @Value("\${temp}")
    val tempPath: String = ""

    @Value("\${real}")
    val realPath: String = ""

    @PostConstruct
    private fun checkValidPath() {
        log().info("{}", tempPath)
        log().info("{}", realPath)
        if (!File(tempPath).exists()) {
            log().info("임시저장소가 없음")
            FileUtils.forceMkdir(File(tempPath))
        }
        if (!File(realPath).exists()) {
            log().info("데이터 저장소가 없음")
            FileUtils.forceMkdir(File(realPath))
        }
    }

//    @Value("\${file.directory.temp}")
//    val tempPath: String = "/Users/kgr/Desktop/TIL/Tech/Spring+Kotlin+Vue/backend/src/tmpDir/"
//
//    @Value("\${file.directory.real}")
//    val realPath: String = "/Users/kgr/Desktop/TIL/Tech/Spring+Kotlin+Vue/backend/src/realDir/"
}