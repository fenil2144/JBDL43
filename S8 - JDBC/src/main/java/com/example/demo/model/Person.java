package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
	
	private int id;
	private String firstName; //first_name
	private String lastName;
	private Integer age;
	private String dob;
	
}
