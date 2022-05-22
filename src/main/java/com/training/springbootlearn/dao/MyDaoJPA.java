package com.training.springbootlearn.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.training.springbootlearn.Student;

@Repository
public class MyDaoJPA {
	
	@PersistenceContext
	EntityManager entityManager;

	
	public Student findById(int id) {
		return entityManager.find(Student.class, id);

	}
	
	public List<Student> findAll() {
		 TypedQuery<Student> namedQuery = entityManager.createNamedQuery("find_all_Students", Student.class); 
		 return namedQuery.getResultList();

	}
	
	public void deleteById(int id) {
		Student student = findById(id);
		entityManager.remove(student);
	}
	
	public void save(Student student) {
		entityManager.merge(student);
	}
	public void update(Student student) {
		entityManager.merge(student);
	}
}
