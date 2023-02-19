package com.example.minorProject2.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.minorProject2.models.Author;
import com.example.minorProject2.repository.AuthorRepositoryInterf;
import com.example.minorProject2.service.AuthorServiceInterf;

@Service
public class AuthorServiceImpl implements AuthorServiceInterf {

	@Autowired
	AuthorRepositoryInterf authorRepositoryInterf;
	
	@Override
	public Author createAuthor(Author author) {
		authorRepositoryInterf.save(author);
		return author;
	}

	@Override
	public Author findByEmail(String email) {
		return authorRepositoryInterf.findByEmail(email);
	}

}
