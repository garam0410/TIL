package com.demo.platform.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PlatformController {

    @GetMapping("/platform")
    public String callPlatform(HttpServletRequest request) {
        log.info("request from : {}", request.getRequestURL());
        return "callPlatform()";
    }
}
