package com.kotlin.test.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMvcConfig : WebMvcConfigurer {

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/tmp/file/**")
                .addResourceLocations("/Users/kgr/Desktop/TIL/Tech/Spring+Kotlin+Vue/backend/src/tmpDir/")

        registry.addResourceHandler("/real/file/**")
                .addResourceLocations("file:///C:/Users/User/Desktop/TIL/Tech/Spring+Kotlin+Vue/backend/src/realDir/")
    }
}