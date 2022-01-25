package com.kotlin.test.util

import org.springframework.beans.factory.annotation.Value

class ValueProperties{
    @Value("\${file.directory}")
    lateinit var test: String


}