package com.kgr.responsebodyadviceexample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InnerSampleModel {
    private Long sampleSeq;
    private Long mailSeq;
    private String description;
    private DeepInnerSampleModel deepInnerSampleModel;
}
