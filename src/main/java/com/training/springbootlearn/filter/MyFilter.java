package com.training.springbootlearn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MyFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
			throws IOException, ServletException {
		System.out.println("START doFilter");
		filterchain.doFilter(request, response);
		System.out.println("END   doFilter");
	}
}