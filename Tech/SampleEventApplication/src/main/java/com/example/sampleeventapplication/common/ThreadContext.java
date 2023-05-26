package com.example.sampleeventapplication.common;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class ThreadContext {

    public static ThreadLocal<List<EventPublishStatusObject>> events = new ThreadLocal<>();

    public static <T> void registerEvent(T event) {
        List<EventPublishStatusObject> eventList = events.get();
        eventList.add(new EventPublishStatusObject(event));
    }

    public static void initEventThread() {
        if (!hasEventThread()) {
            events.set(new ArrayList<>());
        }
    }

    public static void publishRemainEvents() {
        if (!hasEventThread() || !hasAnyEvents()) {
            return;
        }

        List<EventPublishStatusObject> eventList = events.get();
        eventList.stream()
                .filter(EventPublishStatusObject::isNotPublished)
                .forEach(eventPublishStatusObject -> {
                    eventPublishStatusObject.publish();
                    SpringApplicationEventPublisher.registerEvent(eventPublishStatusObject.getEvent());
                });
    }

    public static void clearEventThread() {
        events.remove();
    }

    public static <T> void removeEvent(List<T> unmodifiableList) {
        if (!hasEventThread() || !hasAnyEvents()) {
            return;
        }
        List<EventPublishStatusObject> eventList = events.get();
        List<EventPublishStatusObject> filteredEventList =
                eventList.stream().filter(eventPublishStatusObject ->
                        unmodifiableList.contains(eventPublishStatusObject.getEvent())).toList();
        eventList.removeAll(filteredEventList);
    }

    public static Boolean hasEventThread() {
        return !Objects.isNull(events.get());
    }

    public static Boolean hasAnyEvents() {
        return events.get().size() > 0;
    }

    @Getter
    static class EventPublishStatusObject<T> {

        T event;

        Boolean published = false;

        EventPublishStatusObject(T event) {
            this.event = event;
        }

        public Boolean isNotPublished() {
            return !published;
        }

        public void publish() {
            this.published = true;
        }
    }
}
