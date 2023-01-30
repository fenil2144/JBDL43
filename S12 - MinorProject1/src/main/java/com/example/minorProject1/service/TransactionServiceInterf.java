package com.example.minorProject1.service;

import com.example.minorProject1.exception.TransactionServiceException;

public interface TransactionServiceInterf {
	
	String issueTxn(int studentId,int bookId) throws TransactionServiceException;
	String returntxn(int studentId, int BookId) throws TransactionServiceException;
}
