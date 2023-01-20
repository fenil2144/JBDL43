package com.example.demo.repositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepositoryInterf;

@Repository
public class PersonRepositoryImpl implements PersonRepositoryInterf {
	
	private Connection connection;
	
	public PersonRepositoryImpl(Connection connection) {
		this.connection = connection;
		createTable();
	}
	
	private void createTable() {
		try {
			Statement statement = connection.createStatement();
			statement.execute("create table if not exists person(id int primary key auto_increment,first_name varchar(30)"
					+ "last_name varchar(30), age int , dob varchar(12))");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void createPersonStatic(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createPerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePerson(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return null;
	}

}
