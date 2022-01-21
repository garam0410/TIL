package com.kotlin.test.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class CheckedItem(
    @Id
    @GeneratedValue
    var id: Long,

    @ManyToOne
    var test: Test,

    var itemNumber: Int,

    var itemResult: Int,
)