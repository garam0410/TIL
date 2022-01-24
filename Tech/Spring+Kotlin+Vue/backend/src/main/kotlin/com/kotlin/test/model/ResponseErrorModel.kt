package com.kotlin.test.model

import com.kotlin.test.exception.WebException
import org.springframework.http.HttpStatus

class ResponseErrorModel() {
    var status: HttpStatus? = null
    var errorCode: Int = 0
    var message: String? = ""

    constructor(webException: WebException) : this() {
        status = webException.httpStatus
        errorCode = webException.httpStatus.value()
        message = webException.clientMsg
    }
}