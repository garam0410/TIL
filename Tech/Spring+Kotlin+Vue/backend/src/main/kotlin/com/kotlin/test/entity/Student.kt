package com.kotlin.test.entity

import javax.persistence.*

@Entity
@Table(name = "STUDENT")
class Student(
    @Id
    @GeneratedValue
    var id: Long? = null,
    var name: String,
    var email: String,

    @OneToMany(mappedBy = "student", cascade = [CascadeType.ALL])
    var tests: MutableList<Test> = mutableListOf(),
) {
    fun addTest(t: Test): Unit {
        tests.add(t)
        t.student = this
    }
}