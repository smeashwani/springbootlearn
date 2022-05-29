package com.training.springbootlearn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StudentNotFoundException extends RuntimeException {

		public StudentNotFoundException() {
			
		}
		public StudentNotFoundException(String str) {
			super(str);
		}
}

