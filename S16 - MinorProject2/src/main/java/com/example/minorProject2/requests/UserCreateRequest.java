package com.example.minorProject2.requests;

import com.example.minorProject2.models.Admin;
import com.example.minorProject2.models.Student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserCreateRequest {
	
	private String username;
	private String password;
	private String authority;
	private Student student;
	private Admin admin;
	

}
