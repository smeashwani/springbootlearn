package com.training.springbootlearn;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component()
@Primary
public class DepartmentAdmin implements Department {

	@Override
	public String getName() {
		return "Admin";
	}

}
