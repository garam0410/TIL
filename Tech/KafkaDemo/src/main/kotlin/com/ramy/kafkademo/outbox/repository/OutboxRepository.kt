package com.ramy.kafkademo.outbox.repository

import com.ramy.kafkademo.outbox.entity.Outbox
import org.springframework.data.jpa.repository.JpaRepository

interface OutboxRepository: JpaRepository<Outbox, Long> {
}