package com.training.springbootlearn.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.springbootlearn.dao.MyDaoSpringData;
import com.training.springbootlearn.entity.StudentEntity;

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
	
	public StudentEntity findById(int id) {
		Optional<StudentEntity> findById = dao.findById(id);
		return findById.isPresent()?findById.get():null;
	}
	
	public List<StudentEntity> findAll() {
		return dao.findAll();	
	}
	public void deleteById(int id) {
		dao.deleteById(id);
	}
	public void save(StudentEntity student) {
		dao.save(student);
		
	}
	
	public void update(StudentEntity student) {
		//dao.update(student);
		dao.save(student);
	}
}
