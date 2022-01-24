package com.kotlin.test.controller

import com.kotlin.test.exception.ExceptionDefinition
import com.kotlin.test.exception.GlobalException
import com.kotlin.test.model.StudentModel
import com.kotlin.test.service.TestService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class MainController(
    private val testService: TestService
) {
    @GetMapping("/test")
    fun test(): String {
        println("들어왔다")
        return "test"
    }

    @PostMapping("/insertUserInfo")
    fun insertUserInfo(@RequestBody studentModel: StudentModel): StudentModel{
        return testService.insertUserInfo(studentModel)
    }

    @GetMapping("/exception/{a}")
    fun test(@RequestParam a: String){
        if (a.isNullOrEmpty()){
            throw GlobalException(ExceptionDefinition.BAD_REQUEST)
        }
    }
}