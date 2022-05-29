package com.training.springbootlearn.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.training.springbootlearn.entity.StudentEntity;

@Repository
public class MyDaoJPA {
	
	@PersistenceContext
	EntityManager entityManager;

	
	public StudentEntity findById(int id) {
		return entityManager.find(StudentEntity.class, id);

	}
	
	public List<StudentEntity> findAll() {
		 TypedQuery<StudentEntity> namedQuery = entityManager.createNamedQuery("find_all_Students", StudentEntity.class); 
		 return namedQuery.getResultList();

	}
	
	public void deleteById(int id) {
		StudentEntity student = findById(id);
		entityManager.remove(student);
	}
	
	public void save(StudentEntity student) {
		entityManager.merge(student);
	}
	public void update(StudentEntity student) {
		entityManager.merge(student);
	}
}
