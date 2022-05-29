package com.training.springbootlearn.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery(name="find_all_Students", query="select p from StudentEntity p")
@Table(name = "Student")
public class StudentEntity {

	//@Min(value = 3, message = "At least 3 character long")
	@NotNull
	private String name;
	
	@Id
	@GeneratedValue
	private int id;
	
	//@Column(name = "location", insertable = false)
	@Column(name = "location")
	private String  location;
	
	@Column(name = "birth_Date")
	private Date birthDate;
	
	public StudentEntity(){}
	
	
	public StudentEntity(int id, String name, String location, Date birth_date) {
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
