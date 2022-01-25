package com.kotlin.test.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@PropertySource("classpath:application.yml")
class DocumentProperties(){

    @Value("\${file.directory}")
    val path: String = ""

}