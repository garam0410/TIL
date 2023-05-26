package com.demo.auth.controller;

import com.demo.auth.feign.BusinessClient;
import com.demo.auth.feign.LinkClient;
import com.demo.auth.feign.PlatformClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BasicController {

    private final LinkClient linkClient;
    private final PlatformClient platformClient;
    private final BusinessClient businessClient;

    @GetMapping("/business")
    public String callBusiness() {
        return businessClient.callBusiness();
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
