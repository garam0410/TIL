package com.kgr.responsebodyadviceexample;

import com.kgr.responsebodyadviceexample.model.DeepInnerSampleModel;
import com.kgr.responsebodyadviceexample.model.InnerSampleModel;
import com.kgr.responsebodyadviceexample.model.SampleModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/test")
    public ResponseWrapper test() {
        return new ResponseWrapper(
                new SampleModel(1L, 10L,
                        new InnerSampleModel(2L, 10L, "description",
                                new DeepInnerSampleModel(true, 109011201290L))));
    }

//    @GetMapping("/test")
//    public ResponseWrapper test() {
//        return new ResponseWrapper(
//                new SampleModel(1L, 10L));
//    }
}
