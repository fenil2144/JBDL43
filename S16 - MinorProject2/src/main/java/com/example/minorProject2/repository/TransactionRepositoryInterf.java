package com.example.minorProject2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.minorProject2.enums.TransactionType;
import com.example.minorProject2.models.Book;
import com.example.minorProject2.models.Student;
import com.example.minorProject2.models.Transaction;

public interface TransactionRepositoryInterf extends JpaRepository<Transaction, Integer>{

	Transaction findTopByBookAndStudentAndTransactionTypeOrderByIdDesc(Book book, Student student,
			TransactionType issue);

}
