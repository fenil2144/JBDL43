package com.example.minorProject2.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.minorProject2.models.MyUser;
import com.example.minorProject2.models.Student;
import com.example.minorProject2.requests.StudentCreateRequest;
import com.example.minorProject2.service.StudentServiceInterf;

@RestController
public class StudentController {

	@Autowired
	StudentServiceInterf studentServiceInterf;
	
	//allowed for all
	@PostMapping("/saveStudent")
	public ResponseEntity saveStudent(@Valid  @RequestBody StudentCreateRequest studentCreateRequest) {
		return new ResponseEntity(studentServiceInterf.save(studentCreateRequest),HttpStatus.CREATED);
		
	}
	
	//Only for Student
	@GetMapping("/student")
	public Student getStudent() throws Exception{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MyUser myUser = (MyUser) authentication.getPrincipal();
		
		if(myUser.getStudent() == null) {
			throw new Exception("User is not a Student");
		}
		//select * from student where id =?
		return studentServiceInterf.findById(myUser.getStudent().getId());
	}
	
	//Only for admin
	@GetMapping("/student/Search")
	public Student getStudentById(@RequestParam int id) {
		return null;
	}
	
	//Create API for Updating and Deleting the Student.
	
}
