package com.example.sampleeventapplication.domain;

import com.example.sampleeventapplication.event.SampleEvent;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter
@NoArgsConstructor
public class SampleEntity extends BaseEntity {

    private String text;

    @OneToOne
    private SampleDetailEntity sampleDetailEntity;

    private Boolean published = false;

    @Builder
    public SampleEntity(String text, SampleDetailEntity sampleDetailEntity, Boolean published) {
        this.text = text;
        this.sampleDetailEntity = sampleDetailEntity;
        this.published = published;
    }

    public void publish() {
        this.published = true;
        registerEvent(new SampleEvent(this));
        sampleDetailEntity.publish();
    }

    public void addStr() {
        this.text += "addStr";
    }
}

