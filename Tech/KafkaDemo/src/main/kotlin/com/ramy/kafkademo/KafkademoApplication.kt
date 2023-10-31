package com.ramy.kafkademo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@ConfigurationPropertiesScan
@SpringBootApplication
class KafkademoApplication

fun main(args: Array<String>) {
    runApplication<KafkademoApplication>(*args)
}
