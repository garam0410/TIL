package com.example.sampleeventapplication.domain;

import com.example.sampleeventapplication.event.SampleEvent;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor
public class SampleEntity extends BaseEntity {

    private String text;

    @Builder
    public SampleEntity(String text) {
        this.text = text;
    }

    public void publish() {
        registerEvent(new SampleEvent(this));
    }

    public void addStr() {
        this.text += "addStr";
    }
}
