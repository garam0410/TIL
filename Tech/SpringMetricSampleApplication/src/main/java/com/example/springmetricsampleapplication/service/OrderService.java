package com.example.springmetricsampleapplication.service;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    private final MeterRegistry registry;

    private AtomicInteger stock = new AtomicInteger(100);

    public void order() {
        log.info("주문");
        stock.decrementAndGet();

        Counter.builder("my.order")
                .tag("class", this.getClass().getName()) // OrderServiceV1
                .tag("method", "order") // order
                .description("order")
                .register(registry).increment();
    }

    public void cancel() {
        log.info("취소");
        stock.incrementAndGet();

        Counter.builder("my.order")
                .tag("class", this.getClass().getName())
                .tag("method", "cancel")
                .description("order")
                .register(registry).increment(-1);
    }

    public AtomicInteger getStock() {
        return stock;
    }

}
