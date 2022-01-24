package com.kotlin.test.exception

import org.springframework.http.HttpStatus

class GlobalException() : RuntimeException() {
    var exceptionDefinition: ExceptionDefinition = ExceptionDefinition.INTERNAL_SERVER_ERROR
    var httpStatus:HttpStatus = exceptionDefinition.httpStatus
    var clientMsg: String = exceptionDefinition.clientMsg
    var serverMsg: String = exceptionDefinition.serverMsg

    constructor(exceptionDefinition: ExceptionDefinition) : this() {
        this.httpStatus = exceptionDefinition.httpStatus
        this.clientMsg = exceptionDefinition.clientMsg
        this.serverMsg = exceptionDefinition.serverMsg
    }
}