package com.example.minorProject1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.minorProject1.models.Author;

@Repository
public interface AuthorRepositoryInterf extends JpaRepository<Author, Integer>{

	Author findByEmail(String email);
	
	//Age >=, Country, name starting with 
	
	//1st one - jpql query
//	@Query("select * from Author a where a.age>=?1 and a.country=?2 and a.name like %?3")
	
	
	//2nd One - Native Query
//	@Query("select * from author a where a.age>=?1 and a.country=?2 and a.name like %?3",native = true)


	//3rd Option - writting JPA Function
	List<Author> findByAgeGreaterThanEqualAndCountryAndNameStartingWith(int age, String country, String prefix);
}
