package com.training.springbootlearn;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.training.springbootlearn.service.MyService;

@SpringBootApplication
public class SpringbootlearnWebApplication{
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringbootlearnWebApplication.class, args);
	}
}
