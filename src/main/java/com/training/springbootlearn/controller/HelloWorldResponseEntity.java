package com.training.springbootlearn.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world-resp-entity")
public class HelloWorldResponseEntity {
	
	@RequestMapping(value = "/string", method = RequestMethod.GET)
	public ResponseEntity stringOnly() {
		return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/string", method = RequestMethod.GET)
	public ResponseEntity stringOnly() {
		return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/string", method = RequestMethod.GET)
	public ResponseEntity stringOnly() {
		return ResponseEntity.ok().body("String");
	}
	
	
}
