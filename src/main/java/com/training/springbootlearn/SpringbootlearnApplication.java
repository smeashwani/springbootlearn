package com.training.springbootlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.training.springbootlearn.service.MyService;

@SpringBootApplication
public class SpringbootlearnApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringbootlearnApplication.class, args);
		MyService bean = ctx.getBean(MyService.class);
		System.out.println(bean.getEmployeeName());
		
//		Employee bean = ctx.getBean(Employee.class);
//		System.out.println(bean.getCompanyName());
//		System.out.println(bean);
//		System.out.println(bean.getAddr());
//		System.out.println(bean.getDepartment().getName());
//		
//		Employee bean1 = ctx.getBean(Employee.class);
//		System.out.println(bean1);
//		System.out.println(bean1.getAddr());
//		System.out.println(bean1.getDepartment().getName());
		
//		Student bean = ctx.getBean(Student.class);
//		System.out.println(bean);
//		System.out.println(bean.getSubject());
		
		
	}

}
