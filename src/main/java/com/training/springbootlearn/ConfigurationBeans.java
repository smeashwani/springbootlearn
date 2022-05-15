package com.training.springbootlearn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBeans {
	
	@Bean
	public EmpDetails getDetails() {
		return new EmpDetails();
	}
}
