package com.demo.auth.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "linkClient", url = "http://link:8082")
public interface LinkClient {

    @GetMapping("/link")
    public String callLink();
}
