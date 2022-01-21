package com.kotlin.test.service

import com.kotlin.test.entity.Student
import com.kotlin.test.model.StudentModel
import com.kotlin.test.respository.StudentRepository
import org.springframework.stereotype.Service

@Service
class TestServiceImpl(
    private val studentRepository: StudentRepository
) : TestService {
    override fun insertUserInfo(studentModel: StudentModel): StudentModel {
        if(isDuplicateStudent(studentModel)){
            println("중복 학생 입니다")
            return studentModel
        }

        studentRepository.save(studentModel.toEntity())
        return studentModel;
    }

    fun isDuplicateStudent(studentModel: StudentModel): Boolean {
        var student: Student? = studentRepository.findByName(studentModel.name)

        return student != null
    }
}