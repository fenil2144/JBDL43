package com.example.hibernateDemo.dtos;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponse {
	
	private List<String> message;
	private HttpStatus status;
	private String devMessage;
	private String ApplErrorCode;

}
