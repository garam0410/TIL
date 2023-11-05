package com.ramy.kafkademo.kafka.component

import com.ramy.kafkademo.controller.Message
import com.ramy.kafkademo.kafka.aspect.OffsetSelfSync
import com.ramy.kafkademo.outbox.entity.Outbox
import com.ramy.kafkademo.outbox.service.OutboxService
import com.ramy.kafkademo.redis.RedisOutboxService
import org.apache.kafka.clients.consumer.Consumer
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Component
import java.lang.RuntimeException
import java.util.logging.Logger


@Component
class KafkaBaseProducer(
    private val kafkaTemplate: KafkaTemplate<String, Any>,
    private val redisOutboxService: RedisOutboxService
) {
    fun sendMessage(topic: String, message: Message) {
        redisOutboxService.saveMessage(message)
        kafkaTemplate.send(topic, message)
    }
}

@Component
class KafkaBaseConsumer {

    @OffsetSelfSync
    @KafkaListener(
        topics = ["test.topic.two"],
        groupId = ConsumerConfig.GROUP_ID_CONFIG,
        containerFactory = "kafkaListenerContainerFactory"
    )
    fun consume(message: Message) {
        val log = Logger.getLogger(KafkaBaseConsumer::class.toString())

//        Thread.sleep(2000)
        log.info("payload : ${message.payload}, sendDateTime : ${message.sendDateTime}")
        throw RuntimeException()
    }
}