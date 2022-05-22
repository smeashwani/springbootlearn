package com.training.springbootlearn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.springbootlearn.Student;

@Repository
public interface MyDaoSpringData extends JpaRepository<Student, Integer>{
	
}
