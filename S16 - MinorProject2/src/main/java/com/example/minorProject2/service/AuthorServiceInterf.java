package com.example.minorProject2.service;

import com.example.minorProject2.models.Author;

public interface AuthorServiceInterf {
	
	Author createAuthor(Author author);
	
	Author findByEmail(String email);

}
