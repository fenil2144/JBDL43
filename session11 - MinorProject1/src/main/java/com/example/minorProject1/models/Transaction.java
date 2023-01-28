package com.example.minorProject1.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.example.minorProject1.enums.TransactionType;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Enumerated
	private TransactionType transactionType;
	
	private double payment;
	
	@ManyToOne
	private Book book;
	
	@ManyToOne
	private Student student;
	
	@CreationTimestamp
	private Date createdOn;

}
