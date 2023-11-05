package com.ramy.kafkademo.kafka.config

import com.ramy.kafkademo.redis.RedisOutboxService
import org.apache.kafka.clients.consumer.Consumer
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer.RecordMetadata
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.*
import org.springframework.kafka.listener.CommonErrorHandler
import org.springframework.kafka.listener.ContainerProperties.AckMode.MANUAL
import org.springframework.kafka.listener.MessageListenerContainer
import org.springframework.kafka.support.ProducerListener
import org.springframework.kafka.support.serializer.JsonDeserializer
import org.springframework.kafka.support.serializer.JsonSerializer

@EnableKafka
@Configuration
class KafkaConfig(
    @Value("\${spring.kafka.bootstrap-server}")
    private val bootstrapServer: String,

    @Value("\${spring.kafka.consumer.group-id}")
    private var groupId: String,

    @Value("\${spring.kafka.consumer.auto-offset-reset}")
    private var autoOffsetReset: String,

    private val redisOutboxService: RedisOutboxService
) {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, Any> {
        val factory: ConcurrentKafkaListenerContainerFactory<String, Any> =
            ConcurrentKafkaListenerContainerFactory<String, Any>()
        factory.consumerFactory = consumerFactory()
        factory.setConcurrency(4)
        factory.setCommonErrorHandler(consumerErrorHandler())
        factory.containerProperties.ackMode = MANUAL // 이걸 안하면 consumer exception으로 갈수있음
        return factory
    }

    @Bean
    fun consumerFactory(): ConsumerFactory<String, Any> {
        val props = mutableMapOf<String, Any>()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServer
        props[ConsumerConfig.GROUP_ID_CONFIG] = groupId
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = JsonDeserializer::class.java
        props[ConsumerConfig.AUTO_OFFSET_RESET_CONFIG] = autoOffsetReset
        props[ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG] = "false"
        props[JsonDeserializer.TRUSTED_PACKAGES] = "com.ramy.kafkademo.*"
        return DefaultKafkaConsumerFactory(props)
    }


    @Bean
    fun producerFactory(): ProducerFactory<String, Any> {
        val props = mutableMapOf<String, Any>()
        props[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServer
        props[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        props[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = JsonSerializer::class.java
        props[ProducerConfig.ACKS_CONFIG] = "all"

        val factory = DefaultKafkaProducerFactory<String, Any>(props)

        return factory
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, Any> {
        return KafkaTemplate(producerFactory())
    }

    private fun producerErrorHandler() = object : ProducerListener<String, Any> {

        private val log = LoggerFactory.getLogger(this.javaClass)

        override fun onSuccess(producerRecord: ProducerRecord<String, Any>, recordMetadata: RecordMetadata?) {
            super.onSuccess(producerRecord, recordMetadata)
        }

        override fun onError(
            producerRecord: ProducerRecord<String, Any>?,
            recordMetadata: RecordMetadata?,
            exception: java.lang.Exception?
        ) {
            super.onError(producerRecord, recordMetadata, exception)
        }
    }

    private fun consumerErrorHandler() = object : CommonErrorHandler {

        override fun handleOtherException(
            thrownException: Exception,
            consumer: Consumer<*, *>,
            container: MessageListenerContainer,
            batchListener: Boolean
        ) {
            thrownException.printStackTrace()
        }

        override fun handleRecord(
            e: Exception,
            record: ConsumerRecord<*, *>,
            consumer: Consumer<*, *>,
            container: MessageListenerContainer
        ) {
            log.warn("Global error handler for message: ${e.stackTrace}")
//            val partitionToSeek = record.partition()
//            val assignedPartitions = consumer.assignment()
//            val partition = assignedPartitions.find { it.partition() == partitionToSeek }
//
//            consumer.seek(partition, record.offset())
        }
    }
}