package com.training.springbootlearn.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class MyDao {
	public String getEmployeeName() {
		return "Ducat";
	}
}
