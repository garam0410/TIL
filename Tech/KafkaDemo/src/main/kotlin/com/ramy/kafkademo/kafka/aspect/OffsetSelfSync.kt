package com.ramy.kafkademo.kafka.aspect

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class OffsetSelfSync
