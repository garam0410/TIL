package com.demo.business.controller;

import com.demo.business.feign.AuthClient;
import com.demo.business.feign.LinkClient;
import com.demo.business.feign.PlatformClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BasicController {

    private final AuthClient authClient;
    private final LinkClient linkClient;
    private final PlatformClient platformClient;

    @GetMapping("/auth")
    public String callAuth() {
        return authClient.callAuth();
    }

    @GetMapping("/link")
    public String callLink() {
        return linkClient.callLink();
    }

    @GetMapping("/platform")
    public String callPlatform() {
        return platformClient.callPlatform();
    }
}
