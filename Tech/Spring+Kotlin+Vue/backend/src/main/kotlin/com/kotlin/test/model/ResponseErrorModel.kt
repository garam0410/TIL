package com.kotlin.test.model

import com.kotlin.test.exception.WebException
import org.springframework.http.HttpStatus

class ResponseErrorModel(webException: WebException) {
    val status: HttpStatus = webException.httpStatus
    val errorCode: Int = status.value()
    val message: String = webException.clientMsg

    constructor() : this(WebException())
}