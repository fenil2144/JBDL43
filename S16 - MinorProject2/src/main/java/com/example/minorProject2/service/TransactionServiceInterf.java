package com.example.minorProject2.service;

import com.example.minorProject2.exception.TransactionServiceException;

public interface TransactionServiceInterf {
	
	String issueTxn(int studentId,int bookId) throws TransactionServiceException;
	String returntxn(int studentId, int BookId) throws TransactionServiceException;
}
