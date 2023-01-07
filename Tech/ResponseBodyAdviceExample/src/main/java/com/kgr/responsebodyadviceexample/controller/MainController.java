package com.kgr.responsebodyadviceexample.controller;

import com.kgr.responsebodyadviceexample.core.model.ResponseWrapper;
import com.kgr.responsebodyadviceexample.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @GetMapping("/test")
    public ResponseWrapper insertData(){
        return mainService.insertData();
    }
}
