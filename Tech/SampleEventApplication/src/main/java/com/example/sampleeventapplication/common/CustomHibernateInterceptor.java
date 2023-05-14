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
        ThreadContext.initEventThread();
    }

    @Override
    public void afterTransactionCompletion(Transaction transaction) {
        ThreadContext.publishRemainEvents();
    }
}
