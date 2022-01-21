package com.kotlin.test.entity

import javax.persistence.*

@Entity
@Table(name = "TESTINFO")
class TestInfo(
    @Id
    @GeneratedValue
    var id: Long,

    var name: String,

    @OneToOne(mappedBy = "testInfo")
    var test: Test
)