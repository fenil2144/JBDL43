package com.example.minorProject2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.minorProject2.enums.BookFilterType;
import com.example.minorProject2.enums.BookSearchOperationType;
import com.example.minorProject2.requests.BookCreateRequest;
import com.example.minorProject2.response.BookSearchResponse;
import com.example.minorProject2.service.BookServiceInterf;

@RestController
public class BookController {
	
	@Autowired
	BookServiceInterf bookServiceInterf;
	
	//This should be accessible only by admin
	@PostMapping("/saveBook")
	public ResponseEntity saveBook(@Valid @RequestBody BookCreateRequest bookCreateRequest) {
		bookServiceInterf.create(bookCreateRequest);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	//Add Api for Updating book details
	
	//Used by both - admin and student
	@GetMapping("/books/search")
	public List<BookSearchResponse> findBooks(@RequestParam("filter") BookFilterType bookFilterType,
			@RequestParam("value") String value){
		return bookServiceInterf.findFilteredBooks(bookFilterType, value);
	}
	
	//Used by both - admin and student
	@GetMapping("/books/search/robust")
	public List<BookSearchResponse> findBooks(
			@RequestParam("filter") BookFilterType bookFilterType,
			@RequestParam("value") String value,
			@RequestParam("bookSearchOperationtype") BookSearchOperationType bookSearchOperationtype){
		return bookServiceInterf.findFilteredBooks(bookFilterType, value);
	}
	

}
