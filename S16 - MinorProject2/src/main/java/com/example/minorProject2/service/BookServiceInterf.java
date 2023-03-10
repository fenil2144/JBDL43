package com.example.minorProject2.service;

import java.util.List;

import com.example.minorProject2.enums.BookFilterType;
import com.example.minorProject2.enums.BookSearchOperationType;
import com.example.minorProject2.models.Book;
import com.example.minorProject2.requests.BookCreateRequest;
import com.example.minorProject2.response.BookSearchResponse;

public interface BookServiceInterf {
	
	Book create(BookCreateRequest bookCreateRequest);
	
	Book save(Book book);
	
	Book findById(Integer id);
	
	public List<BookSearchResponse> findFilteredBooks(BookFilterType bookFilterType, String value);
	
	public List<BookSearchResponse> findRobustFilteredBooks(BookFilterType bookFilterType, String value,
			BookSearchOperationType bookSearchOperationType);

	//add update and delete Methods

}
