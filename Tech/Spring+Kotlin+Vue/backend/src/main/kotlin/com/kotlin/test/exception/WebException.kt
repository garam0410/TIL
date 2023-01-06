package com.kotlin.test.exception

import org.springframework.http.HttpStatus

class WebException(exceptionDefinition: ExceptionDefinition) : RuntimeException() {

    val httpStatus: HttpStatus = exceptionDefinition.httpStatus
    val clientMsg: String = exceptionDefinition.clientMsg
    val serverMsg: String = exceptionDefinition.serverMsg

    constructor() : this(ExceptionDefinition.INTERNAL_SERVER_ERROR)
}