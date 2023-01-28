package com.example.multipleDataSource.person;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepositoryInterf extends JpaRepository<Person, Integer>{

}
