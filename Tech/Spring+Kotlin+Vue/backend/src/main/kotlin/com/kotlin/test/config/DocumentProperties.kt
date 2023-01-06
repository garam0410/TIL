package com.kotlin.test.config

import com.kotlin.test.util.log
import org.apache.tomcat.util.http.fileupload.FileUtils
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import java.io.File
import javax.annotation.PostConstruct

@Configuration
class DocumentProperties {

    @Value("\${temp}")
    val tempPath: String = ""

    @Value("\${real}")
    val realPath: String = ""

    @Value("\${host}")
    var hostUrl: String = ""

    @Value("\${server.port}")
    var port: Long? = null

    @PostConstruct
    private fun initPath() {
        if (!File(tempPath).exists()) {
            log().info("임시 저장소 생성")
            FileUtils.forceMkdir(File(tempPath))
        }
        if (!File(realPath).exists()) {
            log().info("실 저장소 생성")
            FileUtils.forceMkdir(File(realPath))
        }
        log().info("tempPath : $tempPath")
        log().info("realPath : $realPath")
    }
}