package com.example.minorProject1.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.minorProject1.enums.BookFilterType;
import com.example.minorProject1.enums.BookSearchOperationType;
import com.example.minorProject1.models.Author;
import com.example.minorProject1.models.Book;
import com.example.minorProject1.repository.BookRepositoryInterf;
import com.example.minorProject1.requests.BookCreateRequest;
import com.example.minorProject1.response.BookSearchResponse;
import com.example.minorProject1.service.AuthorServiceInterf;
import com.example.minorProject1.service.BookServiceInterf;

@Service
public class BookServiceImpl implements BookServiceInterf {
	
	@Autowired
	BookRepositoryInterf bookRepositoryInterf;
	
	@Autowired
	AuthorServiceInterf authorServiceInterf;

	@Override
	public Book create(BookCreateRequest bookCreateRequest) {
		Book book = bookCreateRequest.toBook();
		
		Author author = book.getAuthor();
		
		Author authorfromDb = authorServiceInterf.findByEmail(author.getEmail());
				
		
		if(authorfromDb == null) {
			authorfromDb = authorServiceInterf.createAuthor(author);

		}
		book.setAuthor(authorfromDb);
		
		return bookRepositoryInterf.save(book);

	}

	@Override
	public Book save(Book book) {
		return bookRepositoryInterf.save(book);
	}

	@Override
	public Book findById(Integer id) {
		return bookRepositoryInterf.findById(id).get();
	}
	
	public List<BookSearchResponse> findFilteredBooks(BookFilterType bookFilterType, String value){
		return find(bookFilterType, value).stream()
				.map(book -> book.toBookSearchResponse())
					.collect(Collectors.toList());
	}

	public List<Book> find(BookFilterType bookFilterType, String value) {
		switch(bookFilterType) {
		case NAME:
			return bookRepositoryInterf.findByName(value);
		case GENRE:
			return bookRepositoryInterf.findByGenre(value);
		case AUTHOR_NAME:
			return bookRepositoryInterf.findByAuthor_name(value);
		case COST:
			return bookRepositoryInterf.findByCost(Integer.parseInt(value));
		case ID:
			return bookRepositoryInterf.findAllById(new ArrayList<Integer>(Integer.parseInt(value)));
		}
		return null;
	}

	@Override
	public List<BookSearchResponse> findRobustFilteredBooks(BookFilterType bookFilterType, String value,
			BookSearchOperationType bookSearchOperationType) {
		// TODO 
		return null;
	}

}
