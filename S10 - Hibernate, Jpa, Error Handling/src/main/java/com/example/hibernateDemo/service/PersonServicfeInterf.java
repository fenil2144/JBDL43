package com.example.hibernateDemo.service;

import java.sql.SQLException;
import java.util.List;

import com.example.hibernateDemo.dtos.CreatePersonDto;
import com.example.hibernateDemo.model.Person;


public interface PersonServicfeInterf {
	
	void createPersonStatic(CreatePersonDto createPersonDto);
	
	Person getPersonById(int id);
	
	void deletePerson(int id);
	
	List<Person> getAllPersons() throws SQLException;

}
