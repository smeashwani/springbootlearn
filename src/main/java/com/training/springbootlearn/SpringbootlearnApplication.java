package com.training.springbootlearn;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.training.springbootlearn.entity.StudentEntity;
import com.training.springbootlearn.service.MyService;

//@SpringBootApplication
public class SpringbootlearnApplication implements CommandLineRunner{

	@Autowired
	private MyService service;
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringbootlearnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		StudentEntity stu = service.findById(11);
		System.out.println(stu);
		
		stu.setName("Ducat India");
		service.update(stu);
		
		service.save(new StudentEntity(16,"Ftech","location",new Date()));
		
		List<StudentEntity> findAll = service.findAll();
		System.out.println(findAll);
		
		service.deleteById(12);
 
		System.out.println(service.findAll());
		
		
		
		
	}

}
