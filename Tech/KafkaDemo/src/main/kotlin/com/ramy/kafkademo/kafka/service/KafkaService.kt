package com.ramy.kafkademo.kafka.service

import com.ramy.kafkademo.controller.Message
import com.ramy.kafkademo.kafka.component.KafkaBaseProducer
import org.springframework.stereotype.Service

@Service
class KafkaService(
    private val kafkaKafkaBaseProducer: KafkaBaseProducer
) {
    fun sendMessage(message: Message) {
        kafkaKafkaBaseProducer.sendMessage(message.topic, message)
    }
}