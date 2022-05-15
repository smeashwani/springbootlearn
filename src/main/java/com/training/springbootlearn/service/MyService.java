package com.training.springbootlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.training.springbootlearn.Student;
import com.training.springbootlearn.dao.MyDao;

@Service
public class MyService {
	
	@Autowired
	MyDao dao;
	
	public Student findById(int id) {
		return dao.findById(id);	
	}
	
	public List<Student> findAll() {
		return dao.findAll();	
	}
	public void deleteById(int id) {
		dao.deleteById(id);
	}
	public void save(Student student) {
		dao.save(student);
		
	}
	
	public void update(Student student) {
		dao.update(student);
	}
}
