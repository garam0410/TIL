package com.ramy.kafkademo.outbox.converter

import com.fasterxml.jackson.databind.ObjectMapper
import com.ramy.kafkademo.controller.Message
import jakarta.persistence.AttributeConverter
import org.springframework.stereotype.Component

@Component
class PayloadConverter (
    private val objectMapper: ObjectMapper
) : AttributeConverter<Message, String>{
    override fun convertToDatabaseColumn(attribute: Message): String {
        return objectMapper.writeValueAsString(attribute)
    }

    override fun convertToEntityAttribute(dbData: String): Message {
        return objectMapper.readValue(dbData, Message::class.java)
    }
}