package com.kotlin.test.controller

import com.kotlin.test.model.StudentModel
import com.kotlin.test.service.TestService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController(
    private val testService: TestService
) {
    @GetMapping("/")
    fun test(): String {
        return "test"
    }

    @PostMapping("/insertUserInfo")
    fun insertUserInfo(@RequestBody studentModel: StudentModel): StudentModel{
        return testService.insertUserInfo(studentModel)
    }
}