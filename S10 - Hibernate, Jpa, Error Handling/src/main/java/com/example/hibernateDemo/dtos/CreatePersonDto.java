package com.example.hibernateDemo.dtos;

import javax.validation.constraints.NotBlank;

import com.example.hibernateDemo.model.Person;

import lombok.Data;

@Data
public class CreatePersonDto {
	
	@NotBlank(message = "First Name Should Not be Empty")
	private String firstName;
	private String lastName;
	
	@NotBlank(message="DOB Should Not Be Empty")
	
	private String dob;
	
	public Person to() {
		return Person.builder()
				.firstName(firstName)
				.lastName(lastName)
				.dob(dob).build();
		
//		Person person  = new Person(firstName,lastName,dob);
	}
	
	

}
