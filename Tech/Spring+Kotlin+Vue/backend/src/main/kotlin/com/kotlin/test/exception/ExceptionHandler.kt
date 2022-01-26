package com.kotlin.test.exception

import com.kotlin.test.model.ResponseErrorModel
import com.kotlin.test.util.log
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.multipart.MultipartException
import java.io.IOException

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(value = [WebException::class])
    fun handleWebException(e: WebException): ResponseEntity<ResponseErrorModel> {
        log().error(e.serverMsg)
        return ResponseEntity.status(e.httpStatus).body(ResponseErrorModel(e))
    }

    @ExceptionHandler(value = [RuntimeException::class, IOException::class])
    fun handleGlobalException(): ResponseEntity<ResponseErrorModel> {
        log().error(ExceptionDefinition.INTERNAL_SERVER_ERROR.serverMsg)
        RuntimeException().printStackTrace()
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseErrorModel())
    }
}