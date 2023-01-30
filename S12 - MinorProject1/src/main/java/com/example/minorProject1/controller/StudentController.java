package com.example.minorProject1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.minorProject1.requests.StudentCreateRequest;
import com.example.minorProject1.service.StudentServiceInterf;

@RestController
public class StudentController {

	@Autowired
	StudentServiceInterf studentServiceInterf;
	
	@PostMapping("/saveStudent")
	public ResponseEntity saveStudent(@Valid  @RequestBody StudentCreateRequest studentCreateRequest) {
		return new ResponseEntity(studentServiceInterf.save(studentCreateRequest),HttpStatus.CREATED);
		
	}
}
