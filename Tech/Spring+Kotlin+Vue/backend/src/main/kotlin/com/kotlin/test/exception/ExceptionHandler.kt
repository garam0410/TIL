package com.kotlin.test.exception

import com.kotlin.test.model.ResponseErrorModel
import com.kotlin.test.util.log
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(value = [WebException::class])
    fun handleGlobalException(e: WebException): ResponseErrorModel {
        log().error(e.serverMsg)
        return ResponseErrorModel(e)
    }
}