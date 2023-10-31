package com.ramy.kafkademo.kafka.component

import com.ramy.kafkademo.controller.Message
import com.ramy.kafkademo.outbox.entity.Outbox
import com.ramy.kafkademo.outbox.service.OutboxService
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.sql.DriverManager.println
import java.util.logging.Logger


@Component
class Producer(
    private val kafkaTemplate: KafkaTemplate<String, Any>,
    private val outboxService: OutboxService,
) {
    fun sendMessage(topic: String, message: Message) {
        outboxService.saveMessagePayload(
            Outbox(
                topic = topic,
                uuid = message.uuid,
                payload = message,
                sendDateTime = message.sendDateTime
            )
        )

        kafkaTemplate.send(topic, message)
    }
}

@Component
class Consumer{
    @Async("kafkaListenerThreadPool")
    @KafkaListener(
        topics = ["test.topic"],
        groupId = ConsumerConfig.GROUP_ID_CONFIG,
        containerFactory = "kafkaListenerContainerFactory"
    )
    fun consume(message: Message) {
        val log = Logger.getLogger(Consumer::class.toString())
        log.info("value : , payload : ${message.payload}, sendDateTime : ${message.sendDateTime}")
    }
}