package com.example.startProject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {
	
	private int id;
	private String name;
	private int cost;
	private String author;

}
