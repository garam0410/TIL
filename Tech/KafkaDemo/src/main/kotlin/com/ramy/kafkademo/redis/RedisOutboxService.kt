package com.ramy.kafkademo.redis

import com.ramy.kafkademo.controller.Message
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.SetOperations
import org.springframework.data.redis.core.ValueOperations
import org.springframework.stereotype.Component

@Component
class RedisOutboxService(
    private val redisObjectTemplate: RedisTemplate<String, Any>,
    private val redisStringTemplate: RedisTemplate<String, String>
) {
    private val setOperations: SetOperations<String, String> = redisStringTemplate.opsForSet()
    private val valueOperations: ValueOperations<String, Any> = redisObjectTemplate.opsForValue()

    fun saveMessage(message: Message) {
        valueOperations.set(message.uuid, message)
    }

    fun removeMessage(uuid: String) {
        valueOperations.getAndDelete(uuid)
    }

    fun getMessage(uuid: String): Message {
        return valueOperations.get(uuid) as Message
    }

    fun saveUuidInFailedGroup(uuid: String) {
        setOperations.add("failed-uuids", uuid)
    }

    fun getFailedUuidGroup(): Set<String> {
        return setOperations.members("failed-uuids") ?: emptySet()
    }

    fun removeFailedUuid(uuid: String) {
        setOperations.remove("failed-uuids", uuid)
    }
}