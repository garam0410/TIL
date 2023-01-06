package com.example.customtablegeneratorproject.entity;

import com.example.customtablegeneratorproject.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TestEntity extends BaseEntity {

    Long column_1;
    String column_2;
    int column_3;
}
