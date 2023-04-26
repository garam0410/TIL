package com.example.sampleeventapplication.common;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomHibernateInterceptor extends EmptyInterceptor {

    @Override
    public void afterTransactionBegin(Transaction transaction) {
        log.info("afterTransactionBegin");
        ThreadContext.initEventThread();
    }

    @Override
    public void beforeTransactionCompletion(Transaction transaction) {
        log.info("afterTransactionCompletion");
        ThreadContext.publishRemainEvents();
        ThreadContext.clearEventThread();
    }
}
