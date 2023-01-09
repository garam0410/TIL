package com.example.customtablegeneratorproject.component;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.time.Instant;
import java.util.logging.Logger;

@Component
@NoArgsConstructor
@Slf4j
public class SequenceGenerator {

    private static final int EPOCH_BITS = 41;
    private static final int SEQUENCE_BITS = 9;
    private static final int SERVICE_TYPE_BITS = 1;
    private static final int MOVING_PART_BITS = 13;

    private static final int maxMovingParts = (int) (Math.pow(2, MOVING_PART_BITS));
    private static final int maxSequence = (int) (Math.pow(2, SEQUENCE_BITS));

    private static final long CUSTOM_EPOCH = 1420070400000L;
    private int movingParts;
    private Long saas = 0L;
    private volatile long lastTimestamp = -1L;

    @PostConstruct
    public void init() {
        movingParts = 10 & maxMovingParts;
    }

    private static long timestamp() {
        return Instant.now().toEpochMilli() - CUSTOM_EPOCH;
    }

    public synchronized long nextId(IntegralDataTypeHolder value) {
        long currentTimestamp = timestamp();

        if (currentTimestamp < lastTimestamp) {
            throw new IllegalStateException("Invalid System Clock!");
        }

        long sequence = (long) value.makeValue();

        lastTimestamp = currentTimestamp;
        return makeId(currentTimestamp, sequence % maxSequence);
    }

    private Long makeId(long currentTimestamp, long sequence) {
        long id = 0;

        id |= (currentTimestamp << SEQUENCE_BITS + SERVICE_TYPE_BITS + MOVING_PART_BITS);
        id |= (sequence << SERVICE_TYPE_BITS + MOVING_PART_BITS);
        id |= (saas << MOVING_PART_BITS);
        id |= movingParts;

        return id;
    }
}
