package com.training.springbootlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.training.springbootlearn.dao.MyDao;

@Service
public class MyService {
	
	@Autowired
	MyDao dao;
	
	public String getEmployeeName() {
		return dao.getEmployeeName();
	}
}
