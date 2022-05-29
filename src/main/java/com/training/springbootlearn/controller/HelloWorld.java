package com.training.springbootlearn.controller;

import java.util.Date;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.springbootlearn.entity.StudentEntity;

@RestController
@RequestMapping("/hello-world")
public class HelloWorld {
	
	@RequestMapping(value = "/string", method = RequestMethod.GET)
	public String stringOnly() {
		return "DUCAT";
	}
	
	@GetMapping(value = "/bean")
	public StudentEntity getBean() {
		 return new StudentEntity(1, "Ducat1", "Location", new Date());
	}
	
	@GetMapping(value = "/bean/{id}/details")
	public StudentEntity getPathParamBean(@PathVariable("id") String id) {
		 return new StudentEntity(Integer.parseInt(id), "Ducat1", "Location", new Date());
	}
	
	@GetMapping(value = "/bean_path_param")
	public StudentEntity getPathParam(@PathParam("id") int id) {
		 return new StudentEntity(id, "Ducat1", "Location", new Date());
	}
	
	@GetMapping(value = "/bean_header_param")
	public StudentEntity getHeader(@RequestHeader("id") String id) {
		 return new StudentEntity(Integer.parseInt(id), "Ducat1", "Location", new Date());
	}
	
	@PostMapping(value = "/bean")
	public StudentEntity postBean(@RequestBody StudentEntity stu) {
		stu.setName(stu.getName() + " : update by");
		 return stu;
	}
	
	@DeleteMapping(value = "/bean")
	public StudentEntity deleteBean() {
		 return new StudentEntity(1, "Ducat1", "Location", new Date());
	}
	
	@PutMapping(value = "/bean")
	public StudentEntity putBean() {
		 return new StudentEntity(1, "Ducat1", "Location", new Date());
	}
}
