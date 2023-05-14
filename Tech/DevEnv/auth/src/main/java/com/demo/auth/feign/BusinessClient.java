package com.demo.auth.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "businesClient", url = "http://business:8080")
public interface BusinessClient {

    @GetMapping("/business")
    public String callBusiness();
}
