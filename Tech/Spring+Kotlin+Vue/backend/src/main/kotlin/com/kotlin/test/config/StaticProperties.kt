package com.kotlin.test.config

import org.springframework.stereotype.Component

@Component
class StaticProperties(
    private val properties: DocumentProperties
) {
    fun tempPath(): String = properties.tempPath

    fun realPath(): String = properties.realPath
}