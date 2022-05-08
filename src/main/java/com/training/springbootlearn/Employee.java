package com.training.springbootlearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	private String name;
	
	//@Autowired //Autowiring by type from bean name 'employee' to bean named 'address'
	private Address addr;
	
	//@Autowired //Autowiring by type from bean name 'employee' via constructor to bean named 'address'
	Employee(Address addr){
		this.addr=addr;
	}
	
	@Autowired //Autowiring by type from bean name 'employee' to bean named 'departmentAdmin'
	private Department departmentAdmin; 
	
	public void setDepartment(Department department) {
		this.departmentAdmin = department;
	}
	
	public Department getDepartment() {
		return departmentAdmin;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddr() {
		return addr;
	}
	
	//@Autowired // Autowiring by type from bean name 'employee' to bean named 'address'
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	
	
}
