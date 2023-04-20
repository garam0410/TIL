package com.example.sampleeventapplication.common;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class ThreadContext {

    public static ThreadLocal<ArrayList<Object>> events = new ThreadLocal<>();

    public static <T> void registerEvent(T event) {
        ArrayList<Object> eventList = events.get();
        eventList.add(event);
    }

    static void initEventThread() {
        if (Objects.isNull(events.get())) {
            events.set(new ArrayList<>());
        }
    }

    static void publishRemainEvents() {
        events.get().forEach(SpringApplicationEventPublisher::registerEvent);
    }

    static void removeEventThread() {
        events.remove();
    }

    public static <T> void removeEvent(List<T> unmodifiableList) {
        ArrayList<Object> eventList = events.get();
        eventList.removeAll(unmodifiableList);
    }
}
