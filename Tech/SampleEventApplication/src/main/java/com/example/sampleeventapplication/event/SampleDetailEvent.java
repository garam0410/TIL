package com.example.sampleeventapplication.event;

import com.example.sampleeventapplication.domain.SampleDetailEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
public class SampleDetailEvent {
    private Boolean bool;

    @Builder
    public SampleDetailEvent(SampleDetailEntity sampleDetailEntity) {
        this.bool = sampleDetailEntity.getBool();
    }
}
