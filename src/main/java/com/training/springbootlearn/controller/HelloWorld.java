package com.training.springbootlearn.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.springbootlearn.Student;

@RestController
@RequestMapping("/hello-world")
public class HelloWorld {
	
	@RequestMapping(value = "/string", method = RequestMethod.GET)
	public String stringOnly() {
		return "DUCAT";
	}
	
	@GetMapping(value = "/bean")
	public Student bean() {
		 return new Student(1, "Ducat1", "Location", new Date());
	}
}
