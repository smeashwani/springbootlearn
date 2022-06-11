package com.training.springbootlearn.controller;

import java.net.URI;

import javax.validation.Valid;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.training.springbootlearn.entity.StudentEntity;
import com.training.springbootlearn.exception.StudentNotFoundException;
import com.training.springbootlearn.model.StudentDTO;
import com.training.springbootlearn.service.MyService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private MyService service;
	

	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
	  @ApiResponse(responseCode = "404", description = "id <=0 - The student was not found")
	})
	@GetMapping("/{id}")
	public ResponseEntity getStudent(@PathVariable int id) throws JsonProcessingException {
		StudentEntity stuEntity = service.findById(id);
		if(stuEntity == null) {
			throw new StudentNotFoundException("StudentNotFoundException");
		}
		StudentDTO stu =  new StudentDTO();
	//	stu.setPassword(RandomStringUtils.random(6, true, false));
		BeanUtils.copyProperties(stuEntity,stu);
		
//		Link selfLink = WebMvcLinkBuilder.linkTo(StudentController.class)
//				   .slash(stu.getId()).withSelfRel();
//		stu.add(selfLink);
//		ObjectMapper mapper = new ObjectMapper();
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        FilterProvider filters = new SimpleFilterProvider().setFailOnUnknownId(false).addFilter("StudentFilter",
//                SimpleBeanPropertyFilter.filterOutAllExcept("id"));
//        ObjectWriter writer = mapper.writer(filters);
//        String writeValueAsString = writer.writeValueAsString(stu);
//        StudentDTO stuDto = mapper.readValue(writeValueAsString, StudentDTO.class);
        return ResponseEntity.status(HttpStatus.OK).body(stu); 
	}
	
	@PostMapping()
	public String postStudent(@Valid @RequestBody StudentDTO stu) {
		StudentEntity entity = new StudentEntity();
		BeanUtils.copyProperties(stu,entity);
		service.save(entity);
		return "saved"+ entity.getId();
	}
	
	@PostMapping("/responseEntity")
	public ResponseEntity<Object> postStudent1(@RequestBody StudentEntity stu) {
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
