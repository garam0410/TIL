package com.kotlin.test.exception

import org.springframework.http.HttpStatus

enum class ExceptionDefinition(
        val httpStatus: HttpStatus,
        val serverMsg: String,
        val clientMsg: String,
) {
    // basic
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "정의되지 않은 서버 에러", "정의되지 않은 서버 에러"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청", "잘못된 요청"),

    // file
    BAD_FILE_SIZE(HttpStatus.BAD_REQUEST, "파일 크기 오류", "파일 크기 오류"),
    UPLOAD_FILE_ERROR(HttpStatus.BAD_REQUEST, "업로드할 파일이 없습니다", "업로드할 파일이 없습니다."),
    NOT_FOUND_FILE(HttpStatus.BAD_REQUEST, "파일이 없습니다", "파일이 없습니다")

}