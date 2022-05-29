package com.training.springbootlearn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.training.springbootlearn.entity.StudentEntity;

@Repository
public class MyDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public StudentEntity findById(int id) {
		//return jdbcTemplate.queryForObject("select * from Student where id=?", 
		//		new Object[] { id },new BeanPropertyRowMapper<Student>(Student.class));
		return jdbcTemplate.queryForObject("select * from Student where id=?", 
				new Object[] { id },new StudentRowMapper());

	}
	
	public List<StudentEntity> findAll() {
		 return jdbcTemplate.query("select * from Student", new StudentRowMapper());
	}
	
	public void deleteById(int id) {
		jdbcTemplate.update("delete from Student where id=?", new Object[] { id });
	}
	
	public void save(StudentEntity student) {
		jdbcTemplate.update("insert into Student (id, name, location, birth_date) " + "values(?,  ?, ?, ?)",
				new Object[] { student.getId(), student.getName(), student.getLocation(),new Timestamp(student.getBirthDate().getTime()) });
	}
	public void update(StudentEntity student) {
		jdbcTemplate.update("update Student " + " set name = ?, location = ?, birth_date = ? " + " where id = ?",
				new Object[] { student.getName(), student.getLocation(), new Timestamp(student.getBirthDate().getTime()), student.getId() });

	}
	
	
	class StudentRowMapper implements RowMapper<StudentEntity>{
		@Override
		public StudentEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			StudentEntity Student = new StudentEntity();
			Student.setId(rs.getInt("id"));
			Student.setName(rs.getString("name"));
			Student.setLocation(rs.getString("location"));
			Student.setBirthDate(rs.getTimestamp("birth_date"));
			return Student;
		}
	}

	
	
}
