package com.ramy.kafkademo.controller

import com.ramy.kafkademo.annotation.NoArgs
import com.ramy.kafkademo.kafka.service.KafkaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.util.*

@RestController
class ProducerController(
    private val kafkaService: KafkaService
) {
    @GetMapping("/api")
    fun produceMessage(
        @RequestParam message: String,
        @RequestParam topic: String
    ) {
        kafkaService.sendMessage(
            topic = topic,
            message = Message(
                payload = message
            )
        )
    }
}

@NoArgs
class Message(
    var uuid: String = UUID.randomUUID().toString(),
    var sendDateTime: LocalDateTime = LocalDateTime.now(),
    var payload: String = ""
)