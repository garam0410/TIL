package com.kotlin.test.service

import com.kotlin.test.model.StudentModel

interface TestService {
    fun insertUserInfo(studentModel: StudentModel) : StudentModel
}