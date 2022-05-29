package com.training.springbootlearn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.springbootlearn.entity.StudentEntity;

@Repository
public interface MyDaoSpringData extends JpaRepository<StudentEntity, Integer>{
	
}
