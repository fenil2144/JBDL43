package com.example.minorProject1.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.example.minorProject1.enums.Genre;
import com.example.minorProject1.models.Author;
import com.example.minorProject1.models.Book;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookCreateRequest {
	
	@NotBlank
	private String name;
	
	@Positive
	private int cost;
	
	@NotBlank
	private String isbn;
	
	@NotNull
	private Genre genre;
	
	@NotNull
	private Author author;
	
	public Book toBook() {
		return Book.builder()
				.cost(cost)
				.genre(genre)
				.name(name)
				.author(author)
				.isbn(isbn)
				.build();
	}

}
