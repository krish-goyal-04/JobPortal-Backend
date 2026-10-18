package com.example.JobPortal.config.web;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureApiVersioning(ApiVersionConfigurer configurer){
        configurer.useMediaTypeParameter(MediaType.parseMediaType("application/vnd.example+json"),"v").addSupportedVersions("1.0","2.0","3.0").setDefaultVersion("1.0");
    }
}
