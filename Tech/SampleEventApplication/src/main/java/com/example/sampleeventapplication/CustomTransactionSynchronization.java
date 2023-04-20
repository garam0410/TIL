package com.example.sampleeventapplication;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronization;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomTransactionSynchronization implements TransactionSynchronization {

    @PersistenceContext
    private final EntityManager entityManager;

    public void beforeCommit(boolean readOnly) {
        log.info("before save");
    }

    public void beforeCompletion() {
        log.info("after save");
    }
}
