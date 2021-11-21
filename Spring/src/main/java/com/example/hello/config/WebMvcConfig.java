package com.example.hello.config;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfig implements WebMvcConfigurer {
    
    public static final String[] CALSSPATH_RESOURCE_LOCATION = {
        "calsspath:/static/", "classpath:/public/", "classpath:/",
        "classpath:/resources/", "classpath:/META-INF/resources/",
        "classpath:/META-INF/resources/webjars/"
    };

    @Override
    public void addViewControllers(ViewControllerRegistry registry){

        // "/" 에 해당하는 url 매핑을 /common/test로 forward 한다.
        registry.addViewController("/").setViewName("forward:/index");

        // 우선순위를 가장 높게 설정
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/**").addResourceLocations(CALSSPATH_RESOURCE_LOCATION);
    }
}
