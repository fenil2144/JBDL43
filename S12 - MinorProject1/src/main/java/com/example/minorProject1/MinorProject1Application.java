package com.example.minorProject1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.minorProject1.models.Author;
import com.example.minorProject1.repository.AuthorRepositoryInterf;

@SpringBootApplication
public class MinorProject1Application implements CommandLineRunner{
	
	@Autowired
	AuthorRepositoryInterf authorRepositoryInterf;

	public static void main(String[] args) {
		SpringApplication.run(MinorProject1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inside Run");
		
//		List<Author> authorList = authorRepositoryInterf.findByAgeGreaterThanEqualAndCountryAndNameStartingWith(10,"India","p");
//		authorList.forEach(System.out::println);
	}

}
