package com.kotlin.test.exception

import com.kotlin.test.model.ResponseErrorModel
import mu.KotlinLogging
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

private val log = KotlinLogging.logger {}

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(value = [GlobalException::class])
    fun handleGlobalException(e: GlobalException):ResponseErrorModel{
        log.error(e.serverMsg)
        return ResponseErrorModel(e)
    }
}