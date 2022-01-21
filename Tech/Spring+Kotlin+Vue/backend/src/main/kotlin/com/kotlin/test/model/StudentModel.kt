package com.kotlin.test.model

import com.kotlin.test.entity.Student

class StudentModel(
    var name: String,
    var email: String
) {
    fun toEntity(): Student {
        return Student(
            name = this.name,
            email = this.email
        )
    }
}