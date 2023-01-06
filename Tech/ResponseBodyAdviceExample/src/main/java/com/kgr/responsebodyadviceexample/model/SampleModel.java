package com.kgr.responsebodyadviceexample.model;

import com.kgr.responsebodyadviceexample.model.InnerSampleModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SampleModel {
    private Long id;
    private Long boardId;
    private InnerSampleModel innerSampleModel;
}
