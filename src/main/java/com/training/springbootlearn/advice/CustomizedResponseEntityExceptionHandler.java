package com.training.springbootlearn.advice;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.training.springbootlearn.exception.StudentNotFoundException;
import com.training.springbootlearn.model.ExceptionResponseDTO;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponseDTO exceptionResponse = new ExceptionResponseDTO(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(StudentNotFoundException.class)
	public final ResponseEntity<Object> handleAllExceptions(StudentNotFoundException ex, WebRequest request) {
		ExceptionResponseDTO exceptionResponse = new ExceptionResponseDTO(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
		List<String> erroMsg =  new ArrayList<String>();
		for (ObjectError error : allErrors) {
			erroMsg.add(error.getDefaultMessage());
		}
		ExceptionResponseDTO exceptionResponse = new ExceptionResponseDTO(new Date(), 
				erroMsg.toString(),
				request.getDescription(false));
		return  new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
