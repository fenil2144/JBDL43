package com.example.nosql.demonosql.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void insertBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(int bookId){
    }

    public void updateBook(int bookId, Book book){

    }
}
