package com.example.minorProject1.service;

import com.example.minorProject1.models.Author;

public interface AuthorServiceInterf {
	
	Author createAuthor(Author author);
	
	Author findByEmail(String email);

}
