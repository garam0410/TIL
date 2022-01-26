package com.kotlin.test.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class DocumentProperties() {

//    @Value("\${file.directory.temp}")
//    var tempPath: String = "C:/Users/User/Desktop/TIL/Tech/Spring+Kotlin+Vue/backend/src/tmpDir/"
//
//    @Value("\${file.directory.real}")
//    var realPath: String = "C:/Users/User/Desktop/TIL/Tech/Spring+Kotlin+Vue/backend/src/realDir/"

    @Value("\${test}")
    lateinit var tempPath: String

    @Value("\${real}")
    lateinit var realPath: String

//    @Value("\${file.directory.temp}")
//    val tempPath: String = "/Users/kgr/Desktop/TIL/Tech/Spring+Kotlin+Vue/backend/src/tmpDir/"
//
//    @Value("\${file.directory.real}")
//    val realPath: String = "/Users/kgr/Desktop/TIL/Tech/Spring+Kotlin+Vue/backend/src/realDir/"
}