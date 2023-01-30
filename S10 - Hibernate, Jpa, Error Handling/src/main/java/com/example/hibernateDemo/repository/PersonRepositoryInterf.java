package com.example.hibernateDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hibernateDemo.model.Person;

public interface PersonRepositoryInterf extends JpaRepository<Person, Integer>{
	
	void findByFirstNameAndLastName(String name,String name2);
	void deleteByFirstName(String name);
	
	@Query(value="select * from person where id=:id",nativeQuery=true)
	Person getPerson(int id);
	
	@Query(value="select average(age) from person")
	Integer getAvgPerson();
	
}
