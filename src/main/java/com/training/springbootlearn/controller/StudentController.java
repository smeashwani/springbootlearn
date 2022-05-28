package com.training.springbootlearn.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.training.springbootlearn.Student;
import com.training.springbootlearn.service.MyService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private MyService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable int id) {
		Student stu = service.findById(id);
		if(stu == null) {
			return new ResponseEntity<Student>(stu,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Student>(stu,HttpStatus.OK);
	}
	
	@PostMapping()
	public String postStudent(@RequestBody Student stu) {
		service.save(stu);
		return "saved"+ stu.getId();
	}
	
	@PostMapping("/responseEntity")
	public ResponseEntity<Object> postStudent1(@RequestBody Student stu) {
		service.save(stu);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(stu.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable int id) {
		service.deleteById(id);
		return "Deleted";
	}
	
	
}
