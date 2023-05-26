package com.demo.platform.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "businessClient", url = "http://business:8080")
public interface BusinessClient {

    @GetMapping("/business")
    public String callBusiness();
}
