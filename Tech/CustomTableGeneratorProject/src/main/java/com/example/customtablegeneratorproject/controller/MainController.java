package com.example.customtablegeneratorproject.controller;

import com.example.customtablegeneratorproject.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @GetMapping("/test")
    public void insertData(){
        mainService.insertData();
    }
}
