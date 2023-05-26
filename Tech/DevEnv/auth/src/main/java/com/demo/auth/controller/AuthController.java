package com.demo.auth.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AuthController {

    @GetMapping("/auth")
    public String callAuth(HttpServletRequest request) {
        log.info("request from : {}", request.getRequestURL());
        return "callAuth()";
    }
}
