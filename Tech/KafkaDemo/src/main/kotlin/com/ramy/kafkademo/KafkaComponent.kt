package com.ramy.kafkademo

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import java.sql.DriverManager.println
import java.util.logging.Logger


@Component
class Producer(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    fun sendMessage(message: String) {
        val topicName = "test.topic"
        println("Produce message : $message")
        kafkaTemplate.send(topicName, message)
    }
}

@Component
class Consumer {

    @KafkaListener(topics = ["test.topic"], groupId = ConsumerConfig.GROUP_ID_CONFIG)
    fun consume(message: String) {
        val log = Logger.getLogger(Consumer::class.toString())

        log.info(message)
    }
}