package com.training.springbootlearn.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.springframework.hateoas.RepresentationModel;

public class StudentDTO extends RepresentationModel{
	
	private String name;
	
	private int id;
	
	@NotBlank(message = "should not be empty")
	private String  location;
	
	@Past(message = "date should be past")
	private Date birthDate;
	
	public StudentDTO(){}
	
	
	public StudentDTO(int id, String name, String location, Date birth_date) {
		super();
		this.name = name;
		this.id = id;
		this.location = location;
		this.birthDate = birth_date;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", location=" + location + ", birth_date=" + birthDate + "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
}
