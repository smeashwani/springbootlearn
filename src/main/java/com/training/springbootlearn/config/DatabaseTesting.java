package com.training.springbootlearn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty("DatabaseTesting")
public class DatabaseTesting extends Database {
	@Value("${DatabaseTesting.name}")
	String name;
	@Value("${DatabaseTesting.password}")
	String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
