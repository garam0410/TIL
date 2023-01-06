package com.example.customtablegeneratorproject.entity;

import com.example.customtablegeneratorproject.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MoreTestEntity extends BaseEntity {

    String customValue;
}
