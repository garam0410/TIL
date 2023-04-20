package com.example.sampleeventapplication.domain;

import com.example.sampleeventapplication.common.ThreadContext;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.util.Assert;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
