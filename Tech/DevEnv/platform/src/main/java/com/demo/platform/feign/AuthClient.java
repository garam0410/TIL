package com.demo.platform.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "authClient", url = "http://auth:8083")
public interface AuthClient {

    @GetMapping("/auth")
    public String callAuth();
}
