package com.ramy.kafkademo.kafka.config

import com.ramy.kafkademo.kafka.config.properties.AsyncProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor


@Configuration
@EnableAsync
@EnableConfigurationProperties(
    AsyncProperties::class
)
class AsyncConfig(
    private val asyncProperties: AsyncProperties
) {

    @Bean(name = ["kafkaListenerThreadPool"])
    fun kafkaListenerThreadPool(): ThreadPoolTaskExecutor {
        val executor = ThreadPoolTaskExecutor()
        executor.setThreadNamePrefix(asyncProperties.threadNamePrefix)
        executor.corePoolSize = asyncProperties.corePoolSize
        executor.maxPoolSize = asyncProperties.maxPoolSize
        executor.queueCapacity = asyncProperties.queueCapacity
        executor.initialize()
        return executor
    }
}