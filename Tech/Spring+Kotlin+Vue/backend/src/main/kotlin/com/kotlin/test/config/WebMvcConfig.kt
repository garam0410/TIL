package com.kotlin.test.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMvcConfig : WebMvcConfigurer {

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/file/**")
                .addResourceLocations("file:///C:/Users/User/Desktop/TIL/Tech/Spring+Kotlin+Vue/backend/src/images/")
//                .addResourceLocations("/src/images/")
    }
}