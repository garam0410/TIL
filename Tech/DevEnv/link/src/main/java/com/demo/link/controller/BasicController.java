package com.demo.link.controller;

import com.demo.link.feign.AuthClient;
import com.demo.link.feign.BusinessClient;
import com.demo.link.feign.PlatformClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BasicController {

    private final AuthClient authClient;
    private final BusinessClient businessClient;
    private final PlatformClient platformClient;

    @GetMapping("/auth")
    public String callAuth() {
        return authClient.callAuth();
    }

    @GetMapping("/business")
    public String callBusiness() {
        return businessClient.callBusiness();
    }

    @GetMapping("/platform")
    public String callPlatform() {
        return platformClient.callPlatform();
    }
}

