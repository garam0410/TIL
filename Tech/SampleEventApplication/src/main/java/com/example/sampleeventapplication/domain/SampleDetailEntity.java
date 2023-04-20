package com.example.sampleeventapplication.domain;

import com.example.sampleeventapplication.event.SampleDetailEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor
public class SampleDetailEntity extends BaseEntity{

    private Boolean bool = true;

    public void publish() {
        registerEvent(new SampleDetailEvent(this));
    }
}
