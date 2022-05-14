package com.training.springbootlearn;

import javax.inject.Named;

import org.springframework.stereotype.Component;

@Named
public class Subject {
	private String math;
	private String english;
	private String science;
	public String getMath() {
		return math;
	}
	public void setMath(String math) {
		this.math = math;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getScience() {
		return science;
	}
	public void setScience(String science) {
		this.science = science;
	}
	
}
