package com.springsecurity.filter.springsecurityfilter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.springsecurity.filter.springsecurityfilter.provider.MyAuthenticationProvider;
import com.springsecurity.filter.springsecurityfilter.security.MyBasicCustomAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
 MyAuthenticationProvider provider;
    MyBasicCustomAuthenticationFilter filter;

    @Autowired
    public SecurityConfig(MyAuthenticationProvider provider, MyBasicCustomAuthenticationFilter filter) {
        this.provider = provider;
        this.filter = filter;
    }
   


@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(provider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterAt(filter,BasicAuthenticationFilter.class);
        http.authorizeRequests().anyRequest().permitAll();
    }

@Override
@Bean
public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
}



}
