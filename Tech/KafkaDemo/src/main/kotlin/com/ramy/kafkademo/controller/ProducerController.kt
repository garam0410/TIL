package com.ramy.kafkademo.controller

import com.fasterxml.jackson.annotation.JsonFormat
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
    ): String {
        kafkaService.sendMessage(
            message = Message(
                topic = topic,
                payload = message
            )
        )

        return "message : $message, topic : $topic"
    }
}

@NoArgs
class Message(
    var topic: String,
    var uuid: String = UUID.randomUUID().toString(),
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var sendDateTime: LocalDateTime = LocalDateTime.now(),
    var payload: String = ""
)