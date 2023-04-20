package com.kgr.responsebodyadviceexample.core.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;

@Getter
public class BaseModel {
//    @JsonSerialize(using = ToStringSerializer.class)
    protected Long id;
}
