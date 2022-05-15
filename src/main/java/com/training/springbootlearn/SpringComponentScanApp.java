package com.training.springbootlearn;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.training.springbootlearn1.Employee;

@ComponentScan(basePackages = {"com.training.springbootlearn1","com.training.springbootlearn"})
@PropertySource("classpath:application.properties")
public class SpringComponentScanApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(SpringComponentScanApp.class);
		Employee bean = app.getBean(Employee.class);
		System.out.println(bean);
		System.out.println(bean.getCompanyName());
		System.out.println(bean.getDetails());
	}
}

