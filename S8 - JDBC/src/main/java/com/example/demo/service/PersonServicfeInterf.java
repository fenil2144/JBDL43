package com.example.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.example.demo.dtos.CreatePersonDto;
import com.example.demo.model.Person;

public interface PersonServicfeInterf {
	
	void createPersonStatic(CreatePersonDto createPersonDto);
	
	Person getPersonById(int id);
	
	Person deletePerson(int id);
	
	List<Person> getAllPersons() throws SQLException;

}
