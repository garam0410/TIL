package com.kotlin.test.exception

import org.springframework.http.HttpStatus

class WebException() : RuntimeException() {

    var httpStatus: HttpStatus
    var clientMsg: String
    var serverMsg: String

    init {
        this.httpStatus = ExceptionDefinition.INTERNAL_SERVER_ERROR.httpStatus
        this.clientMsg = ExceptionDefinition.INTERNAL_SERVER_ERROR.clientMsg
        this.serverMsg = ExceptionDefinition.INTERNAL_SERVER_ERROR.serverMsg
    }

    constructor(exceptionDefinition: ExceptionDefinition) : this() {
        this.httpStatus = exceptionDefinition.httpStatus
        this.clientMsg = exceptionDefinition.clientMsg
        this.serverMsg = exceptionDefinition.serverMsg
    }
}