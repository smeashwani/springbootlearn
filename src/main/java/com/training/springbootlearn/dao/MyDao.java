package com.training.springbootlearn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.training.springbootlearn.Student;

@Repository
public class MyDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Student findById(int id) {
		//return jdbcTemplate.queryForObject("select * from Student where id=?", 
		//		new Object[] { id },new BeanPropertyRowMapper<Student>(Student.class));
		return jdbcTemplate.queryForObject("select * from Student where id=?", 
				new Object[] { id },new StudentRowMapper());

	}
	
	public List<Student> findAll() {
		 return jdbcTemplate.query("select * from Student", new StudentRowMapper());
	}
	
	public void deleteById(int id) {
		jdbcTemplate.update("delete from Student where id=?", new Object[] { id });
	}
	
	public void save(Student student) {
		jdbcTemplate.update("insert into Student (id, name, location, birth_date) " + "values(?,  ?, ?, ?)",
				new Object[] { student.getId(), student.getName(), student.getLocation(),new Timestamp(student.getBirthDate().getTime()) });
	}
	public void update(Student student) {
		jdbcTemplate.update("update Student " + " set name = ?, location = ?, birth_date = ? " + " where id = ?",
				new Object[] { student.getName(), student.getLocation(), new Timestamp(student.getBirthDate().getTime()), student.getId() });

	}
	
	
	class StudentRowMapper implements RowMapper<Student>{
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student Student = new Student();
			Student.setId(rs.getInt("id"));
			Student.setName(rs.getString("name"));
			Student.setLocation(rs.getString("location"));
			Student.setBirthDate(rs.getTimestamp("birth_date"));
			return Student;
		}
	}

	
	
}
