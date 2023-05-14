package com.demo.link;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinkApplication.class, args);
    }

}
