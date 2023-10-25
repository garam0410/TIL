package com.ramy.kafkademo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ProducerController(
    private val producer: Producer
) {
    @GetMapping("/api")
    fun produceMessage(@RequestParam message: String) {
        producer.sendMessage(message)
    }
}