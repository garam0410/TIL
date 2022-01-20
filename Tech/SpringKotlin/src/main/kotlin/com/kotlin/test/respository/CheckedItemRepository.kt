package com.kotlin.test.respository

import com.kotlin.test.entity.CheckedItem
import org.springframework.data.jpa.repository.JpaRepository

interface CheckedItemRepository : JpaRepository<CheckedItem, Long> {
}