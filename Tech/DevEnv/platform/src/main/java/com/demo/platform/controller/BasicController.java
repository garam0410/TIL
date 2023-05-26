package com.demo.platform.controller;

import com.demo.platform.feign.AuthClient;
import com.demo.platform.feign.BusinessClient;
import com.demo.platform.feign.LinkClient;
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
    private final BusinessClient businessClient;

    @GetMapping("/auth")
    public String callAuth() {
        return authClient.callAuth();
    }

    @GetMapping("/link")
    public String callLink() {
        return linkClient.callLink();
    }

    @GetMapping("/business")
    public String callBusiness() {
        return businessClient.callBusiness();
    }
}
