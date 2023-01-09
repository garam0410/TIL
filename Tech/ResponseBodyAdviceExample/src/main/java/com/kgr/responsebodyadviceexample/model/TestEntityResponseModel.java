package com.kgr.responsebodyadviceexample.model;

import com.kgr.responsebodyadviceexample.domain.TestEntity;
import lombok.Getter;

@Getter
public class TestEntityResponseModel {
    private Long id;
    private Long column_1;
    private String column_2;
    private int column_3;

    public TestEntityResponseModel(TestEntity testEntity) {
        this.id = testEntity.getId();
        this.column_1 = testEntity.getColumn_1();
        this.column_2 = testEntity.getColumn_2();
        this.column_3 = testEntity.getColumn_3();
    }
}
