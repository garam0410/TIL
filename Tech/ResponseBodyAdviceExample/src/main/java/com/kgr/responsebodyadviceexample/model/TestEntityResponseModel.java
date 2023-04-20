package com.kgr.responsebodyadviceexample.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.kgr.responsebodyadviceexample.core.model.BaseModel;
import com.kgr.responsebodyadviceexample.domain.OtherEntity;
import com.kgr.responsebodyadviceexample.domain.TestEntity;
import lombok.Getter;

@Getter
public class TestEntityResponseModel extends BaseModel {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long otherId;
    private Long column_1;
    private String column_2;
    private int column_3;

    public TestEntityResponseModel(TestEntity testEntity, OtherEntity otherEntity) {
        this.id = testEntity.getId();
        this.otherId = otherEntity.getId();
        this.column_1 = testEntity.getColumn_1();
        this.column_2 = testEntity.getColumn_2();
        this.column_3 = testEntity.getColumn_3();
    }
}