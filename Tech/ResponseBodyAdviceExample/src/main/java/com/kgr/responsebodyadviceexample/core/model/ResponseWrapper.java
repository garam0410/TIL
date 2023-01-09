package com.kgr.responsebodyadviceexample.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseWrapper<T> {
    private T data;
}
