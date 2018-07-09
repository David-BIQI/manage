package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {








    


    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new TimestampStringToDateConverter());
    }
    
}
