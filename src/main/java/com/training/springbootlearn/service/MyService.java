package com.training.springbootlearn.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.springbootlearn.Student;
import com.training.springbootlearn.dao.MyDaoSpringData;

@Service
@Transactional
public class MyService {
	
	/*
	 * @Autowired MyDao dao;
	 */
//	@Autowired
//	MyDaoJPA dao;
	@Autowired
	MyDaoSpringData dao;
	
	public Student findById(int id) {
		Optional<Student> findById = dao.findById(id);
		return findById.isPresent()?findById.get():null;
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
		//dao.update(student);
		dao.save(student);
	}
}
