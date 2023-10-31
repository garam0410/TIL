package com.ramy.kafkademo.kafka.service

import com.ramy.kafkademo.controller.Message
import com.ramy.kafkademo.kafka.component.Producer
import org.springframework.stereotype.Service

@Service
class KafkaService(
    private val kafkaProducer: Producer
) {
    fun sendMessage(topic: String, message: Message) {
        kafkaProducer.sendMessage(topic, message)
    }
}