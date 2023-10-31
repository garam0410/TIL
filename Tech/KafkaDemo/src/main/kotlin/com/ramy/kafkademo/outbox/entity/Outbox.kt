package com.ramy.kafkademo.outbox.entity

import com.ramy.kafkademo.controller.Message
import com.ramy.kafkademo.outbox.converter.PayloadConverter
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
class Outbox (
    @Id
    @GeneratedValue
    val id: Long? = null,

    val uuid: String,

    val topic: String,

    val sendDateTime: LocalDateTime,

    @Convert(converter = PayloadConverter::class)
    val payload: Message,
)