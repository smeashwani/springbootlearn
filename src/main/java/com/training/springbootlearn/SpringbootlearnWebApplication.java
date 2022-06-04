package com.training.springbootlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Hello World",version = "0.0",description = "My API"))
public class SpringbootlearnWebApplication{
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringbootlearnWebApplication.class, args);
	}
}
