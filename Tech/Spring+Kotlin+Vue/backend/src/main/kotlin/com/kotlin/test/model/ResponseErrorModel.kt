package com.kotlin.test.model

import com.kotlin.test.exception.ExceptionDefinition
import com.kotlin.test.exception.WebException
import org.springframework.http.HttpStatus

class ResponseErrorModel() {
    var status: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR
    var errorCode: Int = status.value()
    var message: String = ExceptionDefinition.INTERNAL_SERVER_ERROR.serverMsg

    constructor(webException: WebException) : this() {
        status = webException.httpStatus
        errorCode = webException.httpStatus.value()
        message = webException.clientMsg
    }
}