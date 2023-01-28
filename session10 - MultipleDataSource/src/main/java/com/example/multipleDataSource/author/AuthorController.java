package com.example.multipleDataSource.author;

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
public class AuthorController {

	
	private static Logger logger = LoggerFactory.getLogger(AuthorController.class);
	
	@Autowired
	AuthorRepository authorRepository;


	
	@PostMapping("/addAuthor")
	public ResponseEntity createPerson(@RequestBody @Valid  Author author) throws SQLException {
		logger.info("Author - {}",author);
		Author authorLoc = authorRepository.save(author);
		
		return new ResponseEntity(authorLoc,HttpStatus.CREATED);
		
	}
}
