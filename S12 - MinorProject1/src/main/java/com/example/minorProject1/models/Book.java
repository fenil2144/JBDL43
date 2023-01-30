package com.example.minorProject1.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.minorProject1.enums.Genre;
import com.example.minorProject1.response.BookSearchResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private int cost;
	
	private String isbn;
	
	@Enumerated(value= EnumType.STRING)
	private Genre genre;
	
	@ManyToOne
	@JoinColumn
	private Student student;
	
	@ManyToOne
	@JsonIgnoreProperties({"bookList","country","email"})
	private Author author;
	
	@OneToMany(mappedBy = "book",fetch = FetchType.LAZY)
	private List<Transaction> transactionList;
	
	@CreationTimestamp
	private Date createdOn;
	
	@UpdateTimestamp
	private Date updatedOn;
	
	public BookSearchResponse toBookSearchResponse() {
		
		return BookSearchResponse.builder()
				.id(id)
				.name(name)
				.isbn(isbn)
				.cost(cost)
				.genre(genre)
				.author(author)
				.student(student)
				.createdOn(createdOn)
				.updatedOn(updatedOn)
				.build();
	}
	
}
