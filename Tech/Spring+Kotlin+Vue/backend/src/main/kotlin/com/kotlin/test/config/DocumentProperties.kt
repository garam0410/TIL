package com.kotlin.test.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Configuration
@EnableConfigurationProperties
class DocumentProperties() {

//    @Value("\${temp}")
//    var tempPath: String = "C:/Users/User/Desktop/TIL/Tech/Spring+Kotlin+Vue/backend/src/tmpDir/"
//
//    @Value("\${real}")
//    var realPath: String = "C:/Users/User/Desktop/TIL/Tech/Spring+Kotlin+Vue/backend/src/realDir/"

    @Value("\${temp}")
    var tempPath: String = ""

    @Value("\${real}")
    var realPath: String = ""

//    @Value("\${file.directory.temp}")
//    val tempPath: String = "/Users/kgr/Desktop/TIL/Tech/Spring+Kotlin+Vue/backend/src/tmpDir/"
//
//    @Value("\${file.directory.real}")
//    val realPath: String = "/Users/kgr/Desktop/TIL/Tech/Spring+Kotlin+Vue/backend/src/realDir/"
}