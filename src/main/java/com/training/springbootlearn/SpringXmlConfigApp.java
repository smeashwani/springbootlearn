package com.training.springbootlearn;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.springbootlearn1.Employee;

public class SpringXmlConfigApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext(
				"applicationContext.xml");


		XmlBean bean = (XmlBean) app.getBean("xmlBean");
		System.out.println(bean);
		System.out.println(bean.getName());
		System.out.println(bean.getChild());
		
		Employee bean2 = app.getBean(Employee.class);
		System.out.println(bean2 );
	}
}

