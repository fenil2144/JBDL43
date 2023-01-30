package com.example.demoProject.model;

import org.springframework.stereotype.Component;

@Component
public class Demo {
	
	private int id;
	private String name;
	private String age;
	
	
	public Demo() {
		super();
	}
	public Demo(int id, String name, String age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	

}
