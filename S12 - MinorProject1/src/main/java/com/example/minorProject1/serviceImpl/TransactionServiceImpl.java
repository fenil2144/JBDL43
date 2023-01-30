package com.example.minorProject1.serviceImpl;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.minorProject1.enums.TransactionType;
import com.example.minorProject1.exception.TransactionServiceException;
import com.example.minorProject1.models.Book;
import com.example.minorProject1.models.Student;
import com.example.minorProject1.models.Transaction;
import com.example.minorProject1.repository.TransactionRepositoryInterf;
import com.example.minorProject1.service.BookServiceInterf;
import com.example.minorProject1.service.StudentServiceInterf;
import com.example.minorProject1.service.TransactionServiceInterf;

@Service
public class TransactionServiceImpl implements TransactionServiceInterf {
	
	@Autowired
	TransactionRepositoryInterf transactionRepositoryInterf;
	
	@Autowired
	StudentServiceInterf studentServiceInterf;
	
	@Autowired
	BookServiceInterf bookServiceInterf;
	
	@Value("${book.permissibleDays}")
	int max_days_allowed;

	@Override
	public String issueTxn(int studentId, int bookId) throws TransactionServiceException {
		//check if studentId is valid
		//Check if Book is present and also available
		//made Transaction
		//Make the Book Unavailable
		
		Student student = studentServiceInterf.findById(studentId);
		if(student == null)
			throw new TransactionServiceException("Student Not Present in the Library");
		
		Book book = bookServiceInterf.findById(bookId);
		if(book == null || book.getStudent() != null)
			throw new TransactionServiceException("Book Not Available in the Library");
		
		Transaction transaction = Transaction.builder()
				.externalId(UUID.randomUUID().toString())
				.transactionType(TransactionType.ISSUE)
				.payment(0)
				.book(book)
				.student(student)
				.build();
		
		transactionRepositoryInterf.save(transaction);
		book.setStudent(student);
		bookServiceInterf.save(book);
		
		return transaction.getExternalId();
	}

	@Override
	public String returntxn(int studentId, int bookId) throws TransactionServiceException {
		// TODO Auto-generated method stub
		
		//Checking student
		//Checking Book and also if its already issued to given studentId
		//calculation of Fine
		//Make Transaction
		//Make the Book Available
		
		Student student = studentServiceInterf.findById(studentId);
		if(student == null)
			throw new TransactionServiceException("Student Not Present in the Library");
		
		Book book = bookServiceInterf.findById(bookId);
		if(book == null)
			throw new TransactionServiceException("Book Not Present in the Library");
		
		if(book.getStudent() == null || book.getStudent().getId() != studentId)
			throw new TransactionServiceException("Book Not Issued to the given Student");
		
		Transaction issueTxn = transactionRepositoryInterf.
				findTopByBookAndStudentAndTransactionTypeOrderByIdDesc(book, student, TransactionType.ISSUE);
		
		Transaction transaction = Transaction.builder()
				.externalId(UUID.randomUUID().toString())
				.transactionType(TransactionType.RETURN)
				.payment(calculateFine(issueTxn))
				.book(book)
				.student(student)
				.build();
		
		transactionRepositoryInterf.save(transaction);
		
		book.setStudent(null);
		bookServiceInterf.save(book);
		
		return transaction.getExternalId();
	}
	
	private double calculateFine(Transaction issueTxn) {
		long issuetime = issueTxn.getCreatedOn().getTime();
		long returnTime = System.currentTimeMillis();
		
		long diff = returnTime-issuetime;
		long daysPassed = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
		if(daysPassed> max_days_allowed) {
			return (daysPassed-max_days_allowed)*10.0;
		}
		
		return 0.0;
		
	}
	

}
