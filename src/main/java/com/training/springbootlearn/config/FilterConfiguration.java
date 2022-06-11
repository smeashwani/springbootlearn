package com.training.springbootlearn.config;

import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@Configuration
public class FilterConfiguration {
	public FilterConfiguration(ObjectMapper objectMapper) {
		SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider().setFailOnUnknownId(true);
		simpleFilterProvider.addFilter("studentFilter", SimpleBeanPropertyFilter.filterOutAllExcept("name"));

		objectMapper.setFilterProvider(simpleFilterProvider);
	}
}