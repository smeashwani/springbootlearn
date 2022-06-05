package com.training.springbootlearn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty("DatabaseProd")
public class DatabaseProd extends Database {
	@Value("${DatabaseProd.name}")
	String name;
	@Value("${DatabaseProd.password}")
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
