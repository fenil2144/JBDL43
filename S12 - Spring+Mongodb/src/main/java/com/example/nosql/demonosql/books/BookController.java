package com.example.nosql.demonosql.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping(value = "/books") // fetch / retrieve GET HTTP Method
    public List<Book> getAllBooks(){
        return bookService.getBooks();
    }

    @PostMapping("/book") // posts / saves some data on server
    public void saveBook(@RequestBody Book book) {
        bookService.insertBook(book);
    }

//    @DeleteMapping("/book") // deletes some data on the server
//    public void deleteBookByBookId(@RequestParam("bookId") int bookId){
//        bookService.deleteBook(bookId);
//    }
//
//    @PutMapping("/book") // updates the data on the server
//    public void updateBookByBookId(@RequestParam("bookId") int bookId,
//                                   @RequestBody Book book){
//        bookService.updateBook(bookId, book);
//    }
}
