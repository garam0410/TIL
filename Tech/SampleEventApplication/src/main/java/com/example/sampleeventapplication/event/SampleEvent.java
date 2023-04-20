package com.example.sampleeventapplication.event;

import com.example.sampleeventapplication.domain.SampleEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SampleEvent {
    public Long id;
    public String text;

    public SampleEvent(SampleEntity sampleEntity) {
        this.id = sampleEntity.getId();
        this.text = sampleEntity.getText();
    }
}
