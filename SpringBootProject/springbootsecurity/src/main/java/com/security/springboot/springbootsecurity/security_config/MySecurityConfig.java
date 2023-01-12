package com.security.springboot.springbootsecurity.security_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
// @EnableWebSecurity
public class MySecurityConfig  {

    //Basic Authentication
    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //    http
    //         .authorizeRequests()
    //         .anyRequest()
    //         .authenticated()
    //         .and()
    //         .httpBasic();


    // }
/**
    //Creating USER with Password and Role
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       
        auth.inMemoryAuthentication().withUser("root").password("R5678").roles("NORMAL");
        auth.inMemoryAuthentication().withUser("raju").password("R1234").roles("ADMIN");



    }

    //NoPassword Encoder that means pasword used in plane text.....

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }
  */

  //Creating USER with Password Encrypt.... and Role
//   @Override
//   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
     
//       auth.inMemoryAuthentication().withUser("root").password(this.passwordEncoder().encode("R1234")).roles("NORMAL");
//     //   auth.inMemoryAuthentication().withUser("raju").password("R1234").roles("ADMIN");



//   }

  //NoPassword Encoder that means pasword used in plane text.....

//   @Bean
//   public PasswordEncoder passwordEncoder()
//   {
//       return new BCryptPasswordEncoder(10);
//   }
    

    @Bean
    public UserDetailsService userDetailsService()
    {
        var ud=new InMemoryUserDetailsManager();

        var user=User.withUsername("root").password("root")
        .authorities("read").build();

        ud.createUser(user);

        return ud;
    }

    @Bean 
    public PasswordEncoder passwordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }


}
