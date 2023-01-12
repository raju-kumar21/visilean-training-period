package com.api.book.bootrestbook;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
// @EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
    
    // @Override
    // public void  configureContentNegotiation(ContentNegotiationConfigurer configurer)
    // {

    //     configurer.favorParameter(true).ignoreAcceptHeader(true)
    //     .defaultContentType(MediaType.APPLICATION_JSON).mediaType("xml",MediaType.APPLICATION_XML)
    //     .mediaType("json",MediaType.APPLICATION_JSON);
        
    // }

@Override
public  void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
	
    configurer.favorParameter(true)
        .parameterName("mediaType")
        .defaultContentType(MediaType.APPLICATION_JSON)
        .mediaType("json",MediaType.APPLICATION_JSON)
        .mediaType("xml",MediaType.APPLICATION_XML);

}







}
