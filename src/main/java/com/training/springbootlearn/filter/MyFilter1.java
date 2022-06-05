package com.training.springbootlearn.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Order(2)
public class MyFilter1 extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain)
                                    throws ServletException, IOException {

        System.out.println("Request URI is: " + httpServletRequest.getRequestURI());
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        System.out.println("Response Status Code is: " + httpServletResponse.getStatus());
    }
}
