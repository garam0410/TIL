package com.example.sampleeventapplication;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;


@Aspect
@Component
@RequiredArgsConstructor
@EnableAspectJAutoProxy
public class EventPublisherAspect {

    @PersistenceContext
    private EntityManager entityManager;

    @Around("@annotation(org.springframework.data.domain.DomainEvents)")
    public Object handleEvent(ProceedingJoinPoint joinPoint) throws Throwable {
        TransactionSynchronizationManager.registerSynchronization(new CustomTransactionSynchronization(entityManager));
        Object data = joinPoint.proceed();
        return data;
    }
}
