package com.example.customtablegeneratorproject.component;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Instant;

@Component
@NoArgsConstructor
public class SequenceGenerator {

    private static final int EPOCH_BITS = 41;
    private static final int SEQUENCE_BITS = 9;
    private static final int SERVICE_TYPE_BITS = 1;
    private static final int MOVING_PART_BITS = 13;

    private static final int maxMovingParts = (int) (Math.pow(2, MOVING_PART_BITS) - 1);    // 2^13-1
    private static final int maxSequence = (int) (Math.pow(2, SEQUENCE_BITS) - 1);          // 2^9-1

    private static final long CUSTOM_EPOCH = 1420070400000L;
    private volatile long sequence = 0L;
    private int movingParts;
    private Long saas = 0L;
    private volatile long lastTimestamp = -1L;

    @PostConstruct
    public void init() {
        movingParts = 10 & maxMovingParts;
    }

    // Get current timestamp in milliseconds, adjust for the custom epoch.
    private static long timestamp() {
        return Instant.now().toEpochMilli() - CUSTOM_EPOCH;
    }

    public synchronized long nextId() {
        long currentTimestamp = timestamp();

        if (currentTimestamp < lastTimestamp) {
            throw new IllegalStateException("Invalid System Clock!");
        }

        if (currentTimestamp == lastTimestamp) {
            sequence = (sequence + 1) & maxSequence;
            if (sequence == 0) {
                // Sequence Exhausted, wait till next millisecond.
                currentTimestamp = waitNextMillis(currentTimestamp);
            }
        } else {
            // reset sequence to start with zero for the next millisecond
            sequence = 0;
        }

        lastTimestamp = currentTimestamp;
        return makeId(currentTimestamp);
    }

    private Long makeId(long currentTimestamp) {
        long id = 0;

        id |= (currentTimestamp << SEQUENCE_BITS + SERVICE_TYPE_BITS + MOVING_PART_BITS);
        id |= (sequence << SERVICE_TYPE_BITS + MOVING_PART_BITS);
        id |= (saas << MOVING_PART_BITS);
        id |= movingParts;

        return id;
    }

    // Block and wait till next millisecond
    private long waitNextMillis(long currentTimestamp) {
        while (currentTimestamp == lastTimestamp) {
            currentTimestamp = timestamp();
        }
        return currentTimestamp;
    }
}
