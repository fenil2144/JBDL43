package com.example.demo.repository;

import java.sql.SQLException;
import java.util.List;

import com.example.demo.model.Person;

public interface PersonRepositoryInterf {
	
	void createPersonStatic(Person person);
	
	void createPerson(Person person) throws SQLException;
	
	Person getPersonById(int id);
	
	boolean deletePerson(int id);
	
	List<Person> getAllPersons() throws SQLException;

}
