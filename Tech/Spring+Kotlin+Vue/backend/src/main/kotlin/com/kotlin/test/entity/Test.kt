package com.kotlin.test.entity

import java.util.*
import javax.persistence.*

@Entity
class Test(
    @Id
    @GeneratedValue
    var id: Long,

    @ManyToOne
    var student: Student,

    @OneToOne
    var testInfo: TestInfo,

    @OneToMany(mappedBy = "test", cascade = [CascadeType.ALL])
    var checkedItems: MutableList<CheckedItem> = mutableListOf(),

    @Temporal(TemporalType.DATE)
    var date: Date? = null
) {
    fun setByTestInfo(testInfo: TestInfo): Unit {
        this.testInfo = testInfo
        testInfo.test = this
    }

    fun addCheckedItems(checkedItem: CheckedItem): Unit {
        checkedItems.add(checkedItem)
        checkedItem.test = this
    }
}