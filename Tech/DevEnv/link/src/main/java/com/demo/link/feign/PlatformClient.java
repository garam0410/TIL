package com.demo.link.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "platformClient", url = "http://platform:8081")
public interface PlatformClient {

    @GetMapping("/platform")
    public String callPlatform();
}
