package com.ramy.kafkademo.redis

import com.ramy.kafkademo.controller.Message
import com.ramy.kafkademo.kafka.component.KafkaBaseProducer
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.logging.Logger

@Component
class OutboxScheduler(
    private val redisOutboxService: RedisOutboxService,
    private val kafkaBaseProducer: KafkaBaseProducer
) {
    private val executor: ExecutorService = Executors.newFixedThreadPool(4) // 병렬 처리를 위한 스레드 풀
    private val log = Logger.getLogger(this.javaClass.toString())

    @Scheduled(fixedRate = 5000)
    fun processMessagesInPages() {
        val pageSize = 10 // 한 번에 처리할 페이지 크기

        val uuids = redisOutboxService.getFailedUuidGroup().toList() // Redis Set에서 UUID 가져오기

        // 페이지 단위로 UUID 처리
        for (start in uuids.indices step pageSize) {
            val end = start + pageSize - 1
            val uuidSubset = uuids.subList(start, end.coerceAtMost(uuids.size - 1))

            uuidSubset.forEach { uuid ->
                executor.submit {
                    try {
                        val message = redisOutboxService.getMessage(uuid)
                        log.info("retry failed message : ${message.uuid}, ${message.topic}")
                        kafkaBaseProducer.sendMessage(message.topic, message)
                    } catch (e: Exception) {
                        log.info("retry next time : ${e.stackTrace}")
                    }
                }
            }
        }
    }
}