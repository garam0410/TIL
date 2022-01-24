package com.kotlin.test.model

import com.kotlin.test.exception.GlobalException
import org.springframework.http.HttpStatus

class ResponseErrorModel {
    private var httpStatus: HttpStatus? = null
    private var clientMsg: String = ""

    constructor()

    constructor(globalException: GlobalException) : this() {
        this.httpStatus = globalException.httpStatus
        this.clientMsg = globalException.clientMsg
    }
}