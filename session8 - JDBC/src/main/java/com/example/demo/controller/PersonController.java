package com.example.demo.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.CreatePersonDto;
import com.example.demo.model.Person;
import com.example.demo.service.PersonServicfeInterf;

@RestController
public class PersonController {

	
	private static Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	PersonServicfeInterf personInterf;
	
//  This will give Error	
//	@Autowired
//	CreatePersonDto createPersonDto;
	
//	@GetMapping("/person")
//	public Person getPersonById(@RequestParam("id") int id) {
//		
//	}
	
	@PostMapping("/person")
	public ResponseEntity createPerson(@RequestBody @Valid CreatePersonDto createPersonDto) {
		
//		if(createPersonDto.getFirstName() == null || createPersonDto.getFirstName().isEmpty())
//			logger.error("Invalid Firstname");
//			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		personInterf.createPersonStatic(createPersonDto);
		
		return new ResponseEntity(HttpStatus.CREATED);
		
	}
}
