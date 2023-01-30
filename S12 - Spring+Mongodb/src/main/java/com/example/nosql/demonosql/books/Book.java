package com.example.nosql.demonosql.books;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Book {

    private String name;
    private Author author;
    private int cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
