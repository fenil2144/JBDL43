package com.example.minorProject1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.minorProject1.enums.TransactionType;
import com.example.minorProject1.models.Book;
import com.example.minorProject1.models.Student;
import com.example.minorProject1.models.Transaction;

public interface TransactionRepositoryInterf extends JpaRepository<Transaction, Integer>{

	Transaction findTopByBookAndStudentAndTransactionTypeOrderByIdDesc(Book book, Student student,
			TransactionType issue);

}
