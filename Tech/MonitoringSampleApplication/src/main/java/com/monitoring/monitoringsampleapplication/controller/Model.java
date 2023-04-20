package com.monitoring.monitoringsampleapplication.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Model {
    private String model;
    private String prompt;
    private int max_tokens;
}
