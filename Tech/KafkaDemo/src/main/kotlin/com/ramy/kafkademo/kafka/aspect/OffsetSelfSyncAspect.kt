package com.ramy.kafkademo.kafka.aspect

import com.ramy.kafkademo.controller.Message
import com.ramy.kafkademo.redis.RedisOutboxService
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Component
import java.time.Duration
import java.util.logging.Logger

@Aspect
@Component
class OffsetSelfSyncAspect(
    private val redisOutboxService: RedisOutboxService
) {
    val log = Logger.getLogger(this.javaClass.toString())

    @Around("@annotation(OffsetSelfSync)")
    fun handleKafkaConsumer(consumerMethod: ProceedingJoinPoint) {
        val acknowledgment = consumerMethod.args.firstOrNull { it is Acknowledgment } as Acknowledgment
        val message = consumerMethod.args.firstOrNull() { it is Message } as Message

        try {
            consumerMethod.proceed()
            acknowledgment.acknowledge()

            redisOutboxService.removeMessage(message.uuid)
            redisOutboxService.removeFailedUuid(message.uuid)
        } catch (e: Exception) {
            log.info("Error in Kafka Consumer: ${e.message}")
//            acknowledgment.nack(Duration.ZERO)

            redisOutboxService.saveUuidInFailedGroup(message.uuid)
        }
    }
}