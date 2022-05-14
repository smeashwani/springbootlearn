package com.training.springbootlearn;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Employee {
	
	@Value("${company.name}")
	private String companyName;
	
	private String name;
	
	//@Autowired //Autowiring by type from bean name 'employee' to bean named 'address'
	private Address addr;
	
	//@Autowired //Autowiring by type from bean name 'employee' via constructor to bean named 'address'
	Employee(Address addr){
		this.addr=addr;
	}
	
	@Autowired(required = false) //Autowiring by type from bean name 'employee' to bean named 'departmentAdmin'
	private Department departmentAdmin1; 
	
	public void setDepartment(Department department) {
		this.departmentAdmin1 = department;
	}
	
	public Department getDepartment() {
		return departmentAdmin1;
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
	
	@PostConstruct
	public void init() {
		System.out.println("Ready for use");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Ready for destroy");	
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyName() {
		return companyName;
	}
	
}
