package com.kotlin.test.controller

import com.kotlin.test.model.StudentModel
import com.kotlin.test.service.TestService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class MainController(
        private val testService: TestService,
) {
    @GetMapping("/test")
    fun test(): String {
        println("들어왔다")
        return "test"
    }

    @PostMapping("/insertUserInfo")
    fun insertUserInfo(@RequestBody studentModel: StudentModel): StudentModel {
        return testService.insertUserInfo(studentModel)
    }

    @GetMapping("/exception")
    fun test(@RequestParam a: String) {
        var arr: MutableList<Int> = arrayListOf<Int>(1, 2, 3, 4, 5)
        for (i: Int in 1..10) {
            print(arr.get(i))
        }
    }
}