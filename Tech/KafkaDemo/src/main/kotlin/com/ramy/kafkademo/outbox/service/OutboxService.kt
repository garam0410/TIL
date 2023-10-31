package com.ramy.kafkademo.outbox.service

import com.ramy.kafkademo.outbox.entity.Outbox
import com.ramy.kafkademo.outbox.repository.OutboxRepository
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class OutboxService(
    private val outboxRepository: OutboxRepository
) {

    fun saveMessagePayload(outbox: Outbox) {
        outboxRepository.save(outbox)
    }
}