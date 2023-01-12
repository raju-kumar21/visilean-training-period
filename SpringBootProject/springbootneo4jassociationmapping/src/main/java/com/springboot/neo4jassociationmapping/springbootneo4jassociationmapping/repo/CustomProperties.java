package com.springboot.neo4jassociationmapping.springbootneo4jassociationmapping.repo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@Component
@PropertySources({
    @PropertySource("classpath:custom.properties"),
    @PropertySource("classpath:person.properties")
})
@ConfigurationProperties(prefix = "custom")

public class CustomProperties {

    private String name;

    private String surname;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }



    
}
