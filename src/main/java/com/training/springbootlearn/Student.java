package com.training.springbootlearn;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="find_all_Students", query="select p from Student p")
public class Student {
	
	private String name;
	
	@Id
	private int id;
	private String  location;
	
	@Column(name = "birth_Date")
	private Date birthDate;
	
	public Student(){}
	
	
	public Student(int id, String name, String location, Date birth_date) {
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
