package com.springboot.neo4jassociationmapping.springbootneo4jassociationmapping.repo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:person.properties")
@ConfigurationProperties(prefix = "custom.product")
public class CustomProductProperties {
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
