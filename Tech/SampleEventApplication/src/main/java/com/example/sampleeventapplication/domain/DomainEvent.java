package com.example.sampleeventapplication.domain;

import com.example.sampleeventapplication.common.ThreadContext;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DomainEvent {

    @Transient
    private final transient List<Object> domainEvents = new ArrayList();

    protected <T> void registerEvent(T event) {
        Assert.notNull(event, "Domain event must not be null");
        ThreadContext.registerEvent(event);
        this.domainEvents.add(event);
    }

    @AfterDomainEventPublication
    protected void clearDomainEvents() {
        ThreadContext.removeEvent(Collections.unmodifiableList(domainEvents));
        this.domainEvents.clear();
    }

    @DomainEvents
    protected Collection<Object> domainEvents() {
        return Collections.unmodifiableList(domainEvents);
    }
}
