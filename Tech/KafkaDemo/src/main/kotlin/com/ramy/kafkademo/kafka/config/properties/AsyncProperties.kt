package com.ramy.kafkademo.kafka.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "demo.async-executor")
class AsyncProperties(
    var corePoolSize: Int,
    var maxPoolSize: Int,
    var queueCapacity: Int,
    var threadNamePrefix: String
)