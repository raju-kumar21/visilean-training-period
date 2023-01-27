package com.jwt.demo2.jwtspringdemo2.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jwt.demo2.jwtspringdemo2.service.JwtService;
import com.jwt.demo2.jwtspringdemo2.util.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter  extends OncePerRequestFilter {


    @Autowired 
    private JwtUtil jwtUtil;

    @Lazy
    @Autowired 
    private JwtService jwtService;



    @Override
    protected void doFilterInternal(HttpServletRequest request, 
    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
     
        final String header=request.getHeader("Authorization");


        String jwtToken=null;
        String userName= null;

        if(header != null && header.startsWith("Bearer "))
        {
            jwtToken=header.substring(7);

            try {

                userName= jwtUtil.extractUsername(jwtToken);
                
            } catch (IllegalArgumentException e) {
                System.out.println("Unable to get JWT token");
            }catch(ExpiredJwtException e){
                System.out.println("JWT token is expired");
            }
        }else{
            System.out.println("JWT token does not Start with Bearer...");
        }

        if(userName!=null && SecurityContextHolder.getContext().getAuthentication() == null)
        {

            UserDetails userDetails=jwtService.loadUserByUsername(userName);

            if(jwtUtil.validateToken(jwtToken, userDetails))
            {
                UsernamePasswordAuthenticationToken  authenticationToken =
                 new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
           
                

                 authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
           
                 SecurityContextHolder.getContext().setAuthentication(authenticationToken);
           
            }



        }
        filterChain.doFilter(request, response);

        


        
    }
    
}
