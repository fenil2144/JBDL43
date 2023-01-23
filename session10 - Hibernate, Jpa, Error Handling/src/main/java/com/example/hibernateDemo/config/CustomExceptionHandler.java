package com.example.hibernateDemo.config;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.hibernateDemo.dtos.ErrorResponse;
import com.example.hibernateDemo.exception.PersonNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		
		List<String> errors = fieldErrors.stream()
				.map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());
		
		ErrorResponse errorResponse=  ErrorResponse.builder()
				.message(errors)
				.status(HttpStatus.NOT_ACCEPTABLE)
				.devMessage(ex.getMessage())
				.ApplErrorCode("HBR_501")
				.build();
		
		return new ResponseEntity(errorResponse,HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(PersonNotFoundException.class)
	public ResponseEntity handlePersonNotFoundException(PersonNotFoundException ex) {
		

		
		List<String> errors = new ArrayList<String>();
		errors.add("Person with Id doesn't exist");
		
		ErrorResponse errorResponse=  ErrorResponse.builder()
				.message(errors)
				.status(HttpStatus.NOT_FOUND)
				.devMessage(ex.getMessage())
				.ApplErrorCode("HBR_401")
				.build();
		
		return new ResponseEntity(errorResponse,HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity handleException(Exception ex) {
		
		//change Implementation
//		BindingResult result = ex.getBindingResult();
//		List<FieldError> fieldErrors = result.getFieldErrors();
//		
//		List<String> errors = fieldErrors.stream()
//				.map(x -> x.getDefaultMessage())
//				.collect(Collectors.toList());
//		
//		ErrorResponse errorResponse=  ErrorResponse.builder()
//				.message(errors)
//				.status(HttpStatus.NOT_ACCEPTABLE)
//				.devMessage(ex.getMessage())
//				.ApplErrorCode("HBR_501")
//				.build();
//		
//		return new ResponseEntity(errorResponse,HttpStatus.NOT_ACCEPTABLE);
		return null;
	}

}
