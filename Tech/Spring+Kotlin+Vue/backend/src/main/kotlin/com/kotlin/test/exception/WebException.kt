package com.kotlin.test.exception

import org.springframework.http.HttpStatus

class WebException()
    : RuntimeException() {

    var httpStatus: HttpStatus = ExceptionDefinition.INTERNAL_SERVER_ERROR.httpStatus
    var clientMsg: String = ExceptionDefinition.INTERNAL_SERVER_ERROR.clientMsg
    var serverMsg: String = ExceptionDefinition.INTERNAL_SERVER_ERROR.serverMsg

    constructor(exceptionDefinition: ExceptionDefinition) : this() {
        this.httpStatus = exceptionDefinition.httpStatus
        this.clientMsg = exceptionDefinition.clientMsg
        this.serverMsg = exceptionDefinition.serverMsg
    }
}