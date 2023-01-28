package com.example.multipleDataSource.person;

import java.sql.SQLException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonController {
	
	private static Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	PersonRepositoryInterf personRepositoryInterf;


	
	@PostMapping("/addPerson")
	public ResponseEntity createPerson(@RequestBody @Valid  Person person) throws SQLException {
		logger.info("createPersonRequest - {}",person);
		Person personLoc = personRepositoryInterf.save(person);
		
		return new ResponseEntity(personLoc,HttpStatus.CREATED);
		
	}

}
