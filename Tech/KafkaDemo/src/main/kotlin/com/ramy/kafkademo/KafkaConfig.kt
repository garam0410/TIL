package com.ramy.kafkademo

import com.fasterxml.jackson.databind.deser.std.StringDeserializer
import com.fasterxml.jackson.databind.ser.std.StringSerializer
import org.apache.kafka.clients.admin.AdminClientConfig
import org.apache.kafka.clients.admin.NewTopic
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.producer.ProducerConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.*
import java.util.*

@EnableKafka
@Configuration
class KafkaConfig {
//    @Value(value = "\${spring.kafka.bootstrap-servers}")
//    private val bootstrapAddress: String? = null
//
//    @Bean
//    fun kafkaAdmin(): KafkaAdmin? {
//        val configs: MutableMap<String, Any?> = HashMap()
//        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress)
//        return KafkaAdmin(configs)
//    }
//
//    // ------------------------ Publish 설정 -------------------------------------
//
//    // ------------------------ Publish 설정 -------------------------------------
//    // 테스트 Topic 생성 1
//    @Bean
//    fun myTopic1(): NewTopic? {
//        return NewTopic("my_topic_1", 1, 1.toShort())
//    }
//
//    // 테스트 Topic 생성 2
//    @Bean
//    fun myTopic2(): NewTopic? {
//        return NewTopic("my_topic_2", 1, 1.toShort())
//    }
//
//    @Bean
//    fun producerFactory(): ProducerFactory<String, String> {
//        val configProps: MutableMap<String, Any?> = HashMap()
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress)
//        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer::class)
//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer::class)
//        return DefaultKafkaProducerFactory(configProps)
//    }
//
//    @Bean
//    fun kafkaTemplate(): KafkaTemplate<String?, String?>? {
//        return KafkaTemplate(producerFactory())
//    }
//
//    // ------------------------ Consumer 설정 -------------------------------------
//
//    // ------------------------ Consumer 설정 -------------------------------------
//    @Bean
//    fun consumerFactory(): ConsumerFactory<String?, String?> {
//        val props: MutableMap<String, Any?> = HashMap()
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress)
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, "foo")
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class)
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class)
//        return DefaultKafkaConsumerFactory(props)
//    }
//
//    @Bean
//    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, String>? {
//        val factory = ConcurrentKafkaListenerContainerFactory<String, String>()
//        factory.setConsumerFactory(consumerFactory())
//        return factory
//    }
}